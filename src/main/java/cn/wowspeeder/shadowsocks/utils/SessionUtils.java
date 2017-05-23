package cn.wowspeeder.shadowsocks.utils;


import cn.wowspeeder.shadowsocks.common.SpConst;
import cn.wowspeeder.shadowsocks.dto.LoginUser;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Created by biezhi on 2017/2/14.
 */
public final class SessionUtils {


    public static void set(HttpSession session, String name, Object value) {
        if (null != session && !StringUtils.isEmpty(name) && null != value) {
            removeUser(session);
            session.setAttribute(name, value);
        }
    }

    public static Object get(HttpSession session, String name) {
        if (null != session && !StringUtils.isEmpty(name)) {
            return session.getAttribute(name);
        }
        return null;
    }

    public static void setLoginUser(HttpSession session, LoginUser login_user) {
        if (null != session && null != login_user) {
            removeUser(session);
            session.setAttribute(SpConst.LOGIN_SESSION_KEY, login_user);
        }
    }

    public static void removeUser(HttpSession session) {
        session.removeAttribute(SpConst.LOGIN_SESSION_KEY);
    }

    public static LoginUser getLoginUser(HttpServletRequest request) {
        if (request.getSession(false) == null)  return null;
        Object loginSession = request.getSession(false).getAttribute(SpConst.LOGIN_SESSION_KEY);
        if (loginSession != null) {
            return (LoginUser)loginSession;
        }
        return  null;
    }


    private static final int one_month = 30 * 24 * 60 * 60;

    public static void setLoginCookie(HttpServletResponse response, Integer uid, int time) {
        if (null != response && null != uid) {
            try {
                String val = Utils.encrypt(uid.toString(), SpConst.AES_SALT);
                boolean isSSL = SpConst.SITE_URL.startsWith("https");
                Cookie cookie = new Cookie(SpConst.USER_IN_COOKIE, val);
                cookie.setMaxAge(time);
                cookie.setSecure(isSSL);
                cookie.setPath("/");
                response.addCookie(cookie);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static String getCookie(HttpServletRequest request, String cookieName) {
        if(null != request && !StringUtils.isEmpty(cookieName)){
            String val = null;
            for (Cookie cookie : request.getCookies()) {
                if  (cookie.getName().equals(cookieName)) {
                    val = cookie.getValue();
                    break;
                }
            }
            if(!StringUtils.isEmpty(val)){
                try {
                    return Utils.decrypt(val, SpConst.AES_SALT);
                } catch (Exception e) {
                }
                return "";
            }
        }
        return null;
    }


    public static void removeCookie(HttpServletResponse response) {
        response.addCookie(new Cookie(SpConst.USER_IN_COOKIE, "") {
            @Override
            public void setMaxAge(int expiry) {
                super.setMaxAge(0);
            }
        });
        response.addCookie(new Cookie(SpConst.JC_REFERRER_COOKIE, "") {
            @Override
            public void setMaxAge(int expiry) {
                super.setMaxAge(0);
            }
        });
    }

}
