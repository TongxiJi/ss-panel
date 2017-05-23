package cn.wowspeeder.shadowsocks.controller.admin;

import cn.wowspeeder.shadowsocks.ext.Result;
import cn.wowspeeder.shadowsocks.model.User;
import cn.wowspeeder.shadowsocks.model.UserExample;
import cn.wowspeeder.shadowsocks.service.UserService;
import cn.wowspeeder.shadowsocks.utils.Utils;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller("adminUserController")
@RequestMapping("/admin/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private static final int LIMIT = 15;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView index(@RequestParam(required = false, defaultValue = "1") Integer page) {
        List<User> users = userService.getUsers(null, new RowBounds((page - 1) * LIMIT, LIMIT));
        return new ModelAndView("/admin/user/index", "users", users);
    }

    @RequestMapping(value = "{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable int id) {
        User user = userService.getUserById(id);
        return new ModelAndView("/admin/user/edit", "user", user);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Result update(@PathVariable Integer id,
                         @RequestParam String user_name, @RequestParam String email,
                         @RequestParam String pass, @RequestParam String passwd,
                         @RequestParam Integer port, @RequestParam Double transfer_enable,
                         @RequestParam Integer invite_num, @RequestParam String method,
                         @RequestParam Integer enable, @RequestParam Integer is_admin,
                         @RequestParam Integer ref_by) {

        User user = new User();
        user.setId(id);
        user.setUserName(user_name);
        user.setEmail(email);
        if (!StringUtils.isEmpty(pass)) {
            user.setPass(DigestUtils.md5DigestAsHex(pass.getBytes()));
        }
        if (!StringUtils.isEmpty(passwd)) {
            user.setPasswd(passwd);
        }
        user.setPort(port);
        user.setTransferEnable((long) Utils.toGB(transfer_enable));
        user.setInviteNum(invite_num);
        user.setEnable(enable.byteValue());
        user.setMethod(method);
        user.setIsAdmin(is_admin);
        user.setRefBy(ref_by);
        try {
            userService.update(user);
        } catch (Exception e) {
            LOGGER.error("修改用户失败", e);
            return Result.fail("修改失败");
        }
        return Result.ok("修改成功");
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Result delete(@PathVariable Integer id) {
        try {
            userService.delete(id);
        } catch (Exception e) {
            LOGGER.error("删除用户失败", e);
            return Result.fail("删除失败");
        }
        return Result.ok("删除成功");
    }

    @RequestMapping(value = "{id}/delete", method = RequestMethod.GET)
    public ModelAndView deleteGet(@PathVariable Integer id) {
        try {
            userService.delete(id);
            return new ModelAndView("redirect:/admin/user");
        } catch (Exception e) {
            LOGGER.error("删除用户失败", e);
            return new ModelAndView("redirect:/error");
        }
    }

}
