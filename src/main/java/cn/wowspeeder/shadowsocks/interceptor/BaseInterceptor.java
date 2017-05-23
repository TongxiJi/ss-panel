package cn.wowspeeder.shadowsocks.interceptor;

import cn.wowspeeder.shadowsocks.common.SpConst;
import cn.wowspeeder.shadowsocks.dto.LoginUser;
import cn.wowspeeder.shadowsocks.model.User;
import cn.wowspeeder.shadowsocks.service.UserService;
import cn.wowspeeder.shadowsocks.utils.PatternKit;
import cn.wowspeeder.shadowsocks.utils.SessionUtils;
import cn.wowspeeder.shadowsocks.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户session拦截器
 */
public class BaseInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(BaseInterceptor.class);

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        String uri = request.getServletPath();
//        LOGGE.info("UA >>> " + request.userAgent());
        LOG.info("用户访问地址:{} 来路地址:{}", uri, Utils.getIpAddr(request));

        LoginUser loginUser = SessionUtils.getLoginUser(request);
        if (null == loginUser) {
            String uid = SessionUtils.getCookie(request, SpConst.USER_IN_COOKIE);
            if (!StringUtils.isEmpty(uid) && PatternKit.isNumber(uid)) {
                User user = userService.getUserById(Integer.valueOf(uid));
                SessionUtils.setLoginUser(request.getSession(), new LoginUser(user));
            } else {
                response.addCookie(new Cookie(SpConst.USER_IN_COOKIE, "") {
                    @Override
                    public void setMaxAge(int expiry) {
                        super.setMaxAge(0);
                    }
                });
            }
        } else {
            LOG.debug("用户已登录:{}",loginUser.getUserName());
        }

        if (uri.startsWith("/user") || uri.startsWith("/admin")) {
            if (null == loginUser) {
                try {
                    response.sendRedirect(request.getContextPath() + "/auth/login");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return false;
            }
        }
        return true;
    }

}
