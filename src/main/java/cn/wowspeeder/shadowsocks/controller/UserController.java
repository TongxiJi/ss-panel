package cn.wowspeeder.shadowsocks.controller;

import cn.wowspeeder.shadowsocks.Application;
import cn.wowspeeder.shadowsocks.common.SpConst;
import cn.wowspeeder.shadowsocks.dto.LoginUser;
import cn.wowspeeder.shadowsocks.ext.Functions;
import cn.wowspeeder.shadowsocks.ext.Result;
import cn.wowspeeder.shadowsocks.model.*;
import cn.wowspeeder.shadowsocks.service.*;
import cn.wowspeeder.shadowsocks.utils.DateKit;
import cn.wowspeeder.shadowsocks.utils.Utils;
import com.google.gson.Gson;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/user")
@SessionAttributes(SpConst.LOGIN_SESSION_KEY)
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private static final int LIMIT = 15;

    @Autowired
    private ConfigService configService;

    @Autowired
    private NodeService nodeService;

    @Autowired
    private InviteCodeService inviteCodeService;

    @Autowired
    private UserService userService;

    @Autowired
    private TrafficLogService trafficLogService;

    @Autowired
    private CheckinLogService checkinLogService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index() {
        String msg = configService.getConfig("user_index");
        if (StringUtils.isEmpty(msg)) {
            msg = "在后台修改用户中心公告...";
        }
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("msg", msg);
        return new ModelAndView("/user/index", data);
    }

    @RequestMapping(value = "node", method = RequestMethod.GET)
    public ModelAndView node() {
        Map<String, Object> data = new HashMap<String, Object>();
        String msg = configService.getConfig("user-node");
        NodeExample example = new NodeExample();
        example.createCriteria()
                .andTypeEqualTo(1);
        example.setOrderByClause("sort desc");

        data.put("msg", msg);
        data.put("nodes", nodeService.getNodes(example, new RowBounds()));
        return new ModelAndView("/user/node", data);
    }

    @RequestMapping(value = "node/{id}", method = RequestMethod.GET)
    public ModelAndView nodeInfo(@PathVariable Integer id, @ModelAttribute(SpConst.LOGIN_SESSION_KEY) LoginUser user) {
        Node node = nodeService.byId(id);
        if (null == node) {
            return new ModelAndView("redirect:/auth/login");
        }
        Map<String, Object> ary = new HashMap<>();
        ary.put("server", node.getServer());
        ary.put("server_port", user.getPort());
        ary.put("password", user.getPasswd());
        ary.put("method", node.getMethod());
        if (node.getCustomMethod()) {
            ary.put("method", user.getMethod());
        }

        String json = ary.toString();
        String baseUrl = "";
        String ssurl = ary.get("method") + ":" + ary.get("password") + "@" + ary.get("server") + ":" + ary.get("server_port");
        String ssqr = "ss://" + Base64.getEncoder().encodeToString(ssurl.getBytes());

        String surge_base = Application.getEnvValue("app.baseUrl");
        String surge_proxy = "#!PROXY-OVERRIDE:ProxyBase.conf\\n" +
                "[Proxy]\\n" +
                "Proxy = custom," + ary.get("server") + "," +
                ary.get("server_port") + "," + ary.get("method") + "," +
                ary.get("password") + "," + baseUrl + "/downloads/SSEncrypt.module";

        HashMap<String, Object> data = new HashMap<>();
        data.put("json", json);
        data.put("json_show", new Gson().toJson(ary));
        data.put("ssqr", ssqr);
        data.put("surge_base", surge_base);
        data.put("surge_proxy", surge_proxy);

        return new ModelAndView("/user/nodeinfo", data);
    }

    @RequestMapping(value = "profile", method = RequestMethod.GET)
    public ModelAndView profile() {
        return new ModelAndView("/user/profile");
    }

    @RequestMapping(value = "invite", method = RequestMethod.GET)
    public ModelAndView invite(@ModelAttribute(SpConst.LOGIN_SESSION_KEY) LoginUser user) {
        InviteCodeExample example = new InviteCodeExample();
        example.createCriteria()
                .andUserIdEqualTo(user.getId());
        List<InviteCode> codes = inviteCodeService.getCodes(example);
        return new ModelAndView("/user/invite", "codes", codes);
    }

    @RequestMapping(value = "invite", method = RequestMethod.POST)
    @ResponseBody
    public Result doInvite(@RequestParam Integer num, @ModelAttribute(SpConst.LOGIN_SESSION_KEY) LoginUser user) {
        if (num == null || num < 1 || num > user.getInviteNum()) {
            return Result.fail();
        }
        inviteCodeService.saveCodes(user.getId(), num, "");
        user.setInviteNum(user.getInviteNum() - num);
        User user1 = new User(user.getId());
        user1.setInviteNum(user.getInviteNum());
        userService.update(user1);
        return Result.ok();
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public ModelAndView edit() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("method", SpConst.METHODS);
        return new ModelAndView("/user/edit", data);
    }

    @RequestMapping(value = "password", method = RequestMethod.POST)
    @ResponseBody
    public Result updatePassword(@RequestParam String oldpwd,
                                 @RequestParam String pwd,
                                 @RequestParam String repwd,
                                 @ModelAttribute(SpConst.LOGIN_SESSION_KEY) LoginUser user) {

        if (StringUtils.isEmpty(oldpwd) || !DigestUtils.md5DigestAsHex(oldpwd.getBytes()).equals(user.getPass())) {
            return Result.fail("旧密码错误");
        }

        if (pwd.length() < 6) {
            return Result.fail("密码太短啦");
        }

        if (!pwd.equals(repwd)) {
            return Result.fail("两次输入不符合");
        }

        String hashPwd = DigestUtils.md5DigestAsHex(pwd.getBytes());
        User temp = new User();
        temp.setId(user.getId());
        temp.setPass(hashPwd);
        userService.update(temp);
        return Result.ok("密码修改成功");
    }

    @RequestMapping(value = "sspwd", method = RequestMethod.POST)
    @ResponseBody
    public Result updateSsPwd(@ModelAttribute(SpConst.LOGIN_SESSION_KEY) LoginUser user,
                              @RequestParam String sspwd) {
        if (sspwd.length() < 5) {
            return Result.fail("密码要大于4位或者留空生成随机密码");
        }

        User temp = new User();
        temp.setId(user.getId());
        temp.setPasswd(sspwd);
        userService.update(temp);
        user.setPasswd(sspwd);

        return Result.ok("新密码为: " + sspwd);
    }

    @RequestMapping(value = "method", method = RequestMethod.POST)
    @ResponseBody
    public Result updateMethod(@RequestParam String method,
                               @ModelAttribute(SpConst.LOGIN_SESSION_KEY) LoginUser user) {
        method = method.toLowerCase();

        User temp = new User();
        temp.setId(user.getId());
        temp.setMethod(method);
        userService.update(temp);
        return Result.ok();
    }

    @RequestMapping(value = "sys", method = RequestMethod.GET)
    public ModelAndView sys() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("ana", "");
        return new ModelAndView("/user/sys", data);
    }

    @RequestMapping(value = "trafficlog", method = RequestMethod.GET)
    public ModelAndView trafficlog(@RequestParam(defaultValue = "1", required = false) Integer page,
                                   @ModelAttribute(SpConst.LOGIN_SESSION_KEY) LoginUser user) {
        UserTrafficLogExample example = new UserTrafficLogExample();
        example.setOrderByClause("id desc");
        example.createCriteria()
                .andUserIdEqualTo(user.getId());

        List<UserTrafficLog> logs = trafficLogService.getTrafficLogList(example, new RowBounds((page - 1) * LIMIT, LIMIT));
        return new ModelAndView("/user/trafficlog", "logs", logs);
    }

    @RequestMapping(value = "kill", method = RequestMethod.GET)
    public ModelAndView kill() {
        return new ModelAndView("/user/kill");
    }

    @RequestMapping(value = "kill", method = RequestMethod.POST)
    @ResponseBody
    public Result handleKill(@RequestParam String passwd,
                             @ModelAttribute(SpConst.LOGIN_SESSION_KEY) LoginUser user,
                             HttpSession session,
                             ModelMap modelMap) {
        if (StringUtils.isEmpty(passwd) || !DigestUtils.md5DigestAsHex(passwd.getBytes()).equals(user.getPass())) {
            return Result.fail("密码输入错误");
        }
        try {
            userService.delete(user.getId());
            modelMap.clear();
        } catch (Exception e) {
            LOGGER.error("注销失败", e);
            return Result.fail("注销失败");
        }
        return Result.ok("您的帐号已经从我们的系统中删除.");
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public ModelAndView logout(ModelMap modelMap) {
        modelMap.clear();
        return new ModelAndView("redirect:/auth/login");
    }

    @RequestMapping(value = "checkin", method = RequestMethod.POST)
    @ResponseBody
    public Result doCheckin(@ModelAttribute(SpConst.LOGIN_SESSION_KEY) LoginUser user) {
        if (!user.isAbleToCheckin()) {
            return Result.ok("您似乎已经签到过了...");
        }

        int traffic = Utils.rand(Integer.valueOf(Application.getEnvValue("app.checkinMin")), Integer.valueOf(Application.getEnvValue("app.checkinMax")));

        int trafficToAdd = Utils.toMB(traffic);

        user.setTransferEnable(user.getTransferEnable() + trafficToAdd);
        User temp = new User();
        temp.setId(user.getId());
        temp.setTransferEnable(user.getTransferEnable() + trafficToAdd);
        temp.setLastCheckInTime(DateKit.getCurrentUnixTime());
        userService.update(temp);

        checkinLogService.save(user.getId(), trafficToAdd);
        user.setLastCheckInTime(DateKit.getCurrentUnixTime());
        String msg = String.format("获得了 %s MB流量.", traffic);
        return Result.ok(msg);
    }

}
