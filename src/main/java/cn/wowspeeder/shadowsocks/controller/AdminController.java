package cn.wowspeeder.shadowsocks.controller;

import cn.wowspeeder.shadowsocks.dto.Analytics;
import cn.wowspeeder.shadowsocks.ext.Result;
import cn.wowspeeder.shadowsocks.model.*;
import cn.wowspeeder.shadowsocks.service.*;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
    private static final int LIMIT = 15;

    @Autowired
    private TrafficLogService trafficLogService;

    @Autowired
    private CheckinLogService checkinLogService;

    @Autowired
    private ConfigService configService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private InviteCodeService inviteCodeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index() {
        Analytics sts = adminService.getAnalytics(3600);
        return new ModelAndView("/admin/index", "sts", sts);
    }

    @RequestMapping(value = "trafficlog", method = RequestMethod.GET)
    public ModelAndView trafficlog(@RequestParam(required = false, defaultValue = "1") Integer page) {
        UserTrafficLogExample example = new UserTrafficLogExample();
        example.setOrderByClause("id desc");
        List<UserTrafficLog> logs = trafficLogService.getTrafficLogList(example, new RowBounds((page - 1) * LIMIT, LIMIT));
        return new ModelAndView("/admin/trafficlog", "logs", logs);
    }

    @RequestMapping(value = "checkinlog", method = RequestMethod.GET)
    public ModelAndView checkinlog(@RequestParam(required = false, defaultValue = "1") Integer page) {
        CheckinLogExample example = new CheckinLogExample();
        example.setOrderByClause("id desc");
        List<CheckinLog> paginator = checkinLogService.getLogs(example, new RowBounds((page - 1) * LIMIT, LIMIT));
        return new ModelAndView("/admin/checkinlog", "logs", paginator);
    }

    @RequestMapping(value = "config", method = RequestMethod.GET)
    public ModelAndView config() {
        List<String> configKeys = new ArrayList<>();
        configKeys.add("app_name");
        configKeys.add("home_code");
        configKeys.add("analytics_code");
        configKeys.add("user_index");
        configKeys.add("user_node");
        Map<String, String> config = configService.getConfigs(configKeys);
        return new ModelAndView("/admin/config","config", config);
    }

    @RequestMapping(value = "config", method = RequestMethod.PUT)
    @ResponseBody
    public Result updateConfig(@RequestParam String analyticsCode,
                               @RequestParam String homeCode,
                               @RequestParam String appName,
                               @RequestParam String userIndex,
                               @RequestParam String userNode) {

        configService.updateByKey("analytics_code", analyticsCode);
        configService.updateByKey("home_code", homeCode);
        configService.updateByKey("app_name", appName);
        configService.updateByKey("user_index", userIndex);
        configService.updateByKey("user_node", userNode);
        return Result.ok("更新成功");
    }

    @RequestMapping(value = "invite", method = RequestMethod.GET)
    public ModelAndView invite() {
        InviteCodeExample example = new InviteCodeExample();
        example.createCriteria()
                .andUserIdEqualTo(0);
        List<InviteCode> codes = inviteCodeService.getCodes(example);
        return new ModelAndView("/admin/invite","codes", codes);
    }

    @RequestMapping(value = "invite", method = RequestMethod.POST)
    @ResponseBody
    public Result addInvite(@RequestParam int num, @RequestParam String prefix, @RequestParam int uid) {
        if (num < 1) {
            return Result.fail();
        }
        try {
            inviteCodeService.saveCodes(uid, num, prefix);
        } catch (Exception e) {
            LOGGER.error("邀请码添加失败", e);
            return Result.fail("邀请码添加失败");
        }
        return Result.ok("邀请码添加成功");
    }

}
