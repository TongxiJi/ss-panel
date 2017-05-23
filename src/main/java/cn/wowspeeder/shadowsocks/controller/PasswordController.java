package cn.wowspeeder.shadowsocks.controller;

import cn.wowspeeder.shadowsocks.ext.Result;
import cn.wowspeeder.shadowsocks.model.PasswordReset;
import cn.wowspeeder.shadowsocks.model.User;
import cn.wowspeeder.shadowsocks.service.PasswordResetService;
import cn.wowspeeder.shadowsocks.service.UserService;
import cn.wowspeeder.shadowsocks.utils.DateKit;
import cn.wowspeeder.shadowsocks.utils.PatternKit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/password")
public class PasswordController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PasswordController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordResetService passwordResetService;

    @RequestMapping(value = "reset", method = RequestMethod.GET)
    public ModelAndView reset() {
        return new ModelAndView("/password/reset");
    }

    @RequestMapping(value = "reset", method = RequestMethod.POST)
    @ResponseBody
    public Result handleReset(@RequestParam String email) {
        if (!PatternKit.isEmail(email)) {
            return Result.fail("错误的邮箱格式");
        }
        User user = userService.byEmail(email);
        if (null == user) {
            return Result.fail("此邮箱不存在.");
        }
        try {
            passwordResetService.sendResetEmail(email);
        } catch (Exception e) {
            LOGGER.error("", e);
            return Result.fail("重置密码失败");
        }
        return Result.ok("重置邮件已经发送,请检查邮箱.");
    }

    @RequestMapping(value = "token", method = RequestMethod.GET)
    public ModelAndView token(@RequestParam String c) {
        return new ModelAndView("/password/token", "token", c);
    }

    @RequestMapping(value = "token", method = RequestMethod.POST)
    @ResponseBody
    public Result handleToken(@RequestParam String token,
                              @RequestParam String password) {

        PasswordReset passwordReset = passwordResetService.byToken(token);
        if (null == passwordReset || passwordReset.getExpireTime() < DateKit.getCurrentUnixTime()) {
            return Result.fail("链接已经失效,请重新获取");
        }

        User user = userService.byEmail(passwordReset.getEmail());
        if (null == user) {
            return Result.fail("链接已经失效,请重新获取");
        }

        if (StringUtils.isEmpty(password)) {
            return Result.fail("请输入密码");
        }

        if (password.length() < 6) {
            return Result.fail("密码太短了");
        }

        String pwd = DigestUtils.md5DigestAsHex(password.getBytes());
        User temp = new User();
        temp.setId(user.getId());
        temp.setPass(pwd);
        userService.update(temp);

        return Result.ok("重置成功");
    }

}
