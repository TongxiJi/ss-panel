package cn.wowspeeder.shadowsocks.controller;

import cn.wowspeeder.shadowsocks.Application;
import cn.wowspeeder.shadowsocks.common.SpConst;
import cn.wowspeeder.shadowsocks.dto.LoginUser;
import cn.wowspeeder.shadowsocks.ext.Functions;
import cn.wowspeeder.shadowsocks.ext.Result;
import cn.wowspeeder.shadowsocks.model.InviteCode;
import cn.wowspeeder.shadowsocks.model.User;
import cn.wowspeeder.shadowsocks.service.ConfigService;
import cn.wowspeeder.shadowsocks.service.EmailVerifyService;
import cn.wowspeeder.shadowsocks.service.InviteCodeService;
import cn.wowspeeder.shadowsocks.service.UserService;
import cn.wowspeeder.shadowsocks.utils.DateKit;
import cn.wowspeeder.shadowsocks.utils.PatternKit;
import cn.wowspeeder.shadowsocks.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;

@Controller
@RequestMapping("/auth")
@SessionAttributes(SpConst.LOGIN_SESSION_KEY)
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);


    // Register Error Code
    private final int WrongCode = 501;
    private final int IllegalEmail = 502;
    private final int PasswordTooShort = 511;
    private final int PasswordNotEqual = 512;
    private final int EmailUsed = 521;

    // Login Error Code
    private final int UserNotExist = 601;
    private final int UserPasswordWrong = 602;

    // Verify Email
    private final int VerifyEmailWrongEmail = 701;
    private final int VerifyEmailExist = 702;

    @Autowired
    private UserService userService;

    @Autowired
    private ConfigService configService;

    @Autowired
    private InviteCodeService inviteCodeService;

    @Autowired
    private EmailVerifyService emailVerifyService;

    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("auth/login");
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public Result doLogin(@RequestParam String email, @RequestParam String passwd,
                          @RequestParam String remember_me, HttpSession session, ModelMap modelMap) {
        email = email.toLowerCase();
        User user = userService.byEmail(email);

        if (null == user) {
            return Result.fail(UserNotExist, "邮箱或者密码错误");
        }

        if (!DigestUtils.md5DigestAsHex(passwd.getBytes()).equals(user.getPass())) {
            return Result.fail(UserPasswordWrong, "邮箱或者密码错误");
        }
        int time = 3600 * 24;
        if (!StringUtils.isEmpty(remember_me)) {
            time = 3600 * 24 * 7;
        }
        LOGGER.info("login user {}", user.getId());
        modelMap.addAttribute(SpConst.LOGIN_SESSION_KEY, new LoginUser(user));

        //// TODO: 2017/5/22   cookie加值
//        SessionUtils.setLoginCookie(response, user.getId(), time);
        return Result.ok("欢迎回来");
    }

    /**
     * 注册页面
     *
     * @return
     */
    @RequestMapping(value = "register", method = RequestMethod.GET)
    public ModelAndView register(@RequestParam(required = false) String code) {
        String requireEmailVerification = Functions.config("app.emailVerifyEnabled");
        HashMap<String, Object> data = new HashMap<>();
        data.put("code", code);
        data.put("requireEmailVerification", requireEmailVerification);
        return new ModelAndView("auth/register", data);
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    @ResponseBody
    public Result doRegister(@RequestParam String name, @RequestParam String email,
                             @RequestParam String passwd, @RequestParam String repasswd,
                             @RequestParam String code, @RequestParam String verifycode,
                             HttpServletRequest request) {
        //TODO  图像验证码

        email = email.toLowerCase();

        InviteCode c = inviteCodeService.byCode(code);
        if (null == c) {
            return Result.fail(WrongCode, "邀请码无效");
        }

        if (!PatternKit.isEmail(email)) {
            return Result.fail(IllegalEmail, "邮箱无效");
        }

        if (passwd.length() < 8) {
            return Result.fail(PasswordTooShort, "密码太短");
        }

        if (!passwd.equals(repasswd)) {
            return Result.fail(PasswordNotEqual, "两次密码输入不符");
        }

        User user = userService.byEmail(email);
        if (null != user) {
            return Result.fail(EmailUsed, "邮箱已经被注册了");
        }

        if (Boolean.parseBoolean(Application.getEnvValue("app.emailVerifyEnabled")) &&
                !emailVerifyService.checkVerifyCode(email, verifycode)) {
            return Result.fail("邮箱验证代码不正确");
        }

        String ip = Utils.getIpAddr(request);
        int ipRegCount = userService.getIpRegCount(ip);
        if (ipRegCount >= Integer.valueOf(Functions.config("app.ipDayLimit"))) {
            return Result.fail("当前IP注册次数超过限制");
        }
        User temp = new User();
        temp.setUserName(name);
        temp.setEmail(email);
        temp.setPass(DigestUtils.md5DigestAsHex(passwd.getBytes()));
        temp.setPasswd(Utils.getRandomChar(6));
        temp.setPort(userService.getLastPort() + 1);
        temp.setRegDate(DateKit.getCurrentUnixTime());
        temp.setT(0);
        temp.setU(0L);
        temp.setD(0L);
        // TODO: 2017/5/23  更新不了需要修复
        temp.setTransferEnable(Utils.toGB(Double.valueOf(Functions.config("app.defaultTraffic"))));
        temp.setInviteNum(Integer.valueOf(Functions.config("app.inviteNum")));
        temp.setRegIp(ip);
        temp.setRefBy(c.getUserId());

        try {
            userService.save(temp);
            inviteCodeService.delete(c.getId());
        } catch (Exception e) {
            LOGGER.error("注册失败", e);
            return Result.fail("注册失败");
        }
        return Result.ok("注册成功");
    }

    @RequestMapping(value = "sendcode", method = RequestMethod.POST)
    @ResponseBody
    public Result sendVerifyEmail(@RequestParam String email) {
        email = email.toLowerCase();

        if (!PatternKit.isEmail(email)) {
            return Result.fail(VerifyEmailWrongEmail, "邮箱无效");
        }

        User user = userService.byEmail(email);
        if (null != user) {
            return Result.fail(VerifyEmailExist, "邮箱已经被注册了");
        }

        try {
            emailVerifyService.sendVerification(email);
        } catch (Exception e) {
            LOGGER.error("邮件发送失败", e);
            return Result.fail("邮件发送失败，请联系管理员");
        }
        return Result.ok("验证代码已发送至您的邮箱，请在登录邮箱后将验证码填到相应位置.");
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public ModelAndView logout(ModelMap modelMap) {
        modelMap.clear();
        return new ModelAndView("redirect:/auth/login");
    }

}
