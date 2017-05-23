package cn.wowspeeder.shadowsocks.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * @author:TongxiJi E-MAIL:694270875@qq.com
 * Function:
 * Create Date:四月21,2017
 */
@Service
public class SpConst {
    public static Properties APP_PROPERTIES;

    @Autowired
    public void setAppProperties(@Qualifier("app-props") Properties properties){
        SpConst.APP_PROPERTIES = properties;
        SpConst.SITE_URL = String.valueOf(APP_PROPERTIES.get("app.baseUrl"));
        SpConst.MAIL_HOST = String.valueOf(APP_PROPERTIES.get("mail.smtp.host"));
        SpConst.MAIL_USER = String.valueOf(APP_PROPERTIES.get("mail.user"));
        SpConst.MAIL_USERNAME = String.valueOf(APP_PROPERTIES.get("mail.from"));
        SpConst.MAIL_PASS = String.valueOf(APP_PROPERTIES.get("mail.pass"));
    }

    public static final String LOGIN_SESSION_KEY = "login_user";

    public static final String USER_IN_COOKIE = "SH_SIGNIN_USER";

    public static final String JC_REFERRER_COOKIE = "JC_REFERRER_COOKIE";

    public static String SITE_URL = "";

    public static String AES_SALT = "0123456789abcdef";

    /**
     * 邮件配置
     */
    public static String MAIL_HOST;
    public static String MAIL_USER;
    public static String MAIL_USERNAME;
    public static String MAIL_PASS;

    public static String[] METHODS = {"rc4-md5", "aes-128-cfb", "aes-192-cfb", "aes-256-cfb", "des-cfb", "bf-cfb", "cast5-cfb", "chacha20", "salsa20"};


}
