package cn.wowspeeder.shadowsocks.common;


/**
 * @author:TongxiJi E-MAIL:694270875@qq.com
 * Function:
 * Create Date:四月21,2017
 */
public class SpConst {
    public static final String LOGIN_SESSION_KEY = "login_user";

    public static final String USER_IN_COOKIE = "SH_SIGNIN_USER";

    public static final String JC_REFERRER_COOKIE = "JC_REFERRER_COOKIE";

    public static String AES_SALT = "0123456789abcdef";
    /**
     * 邮件配置
     */

    public static String[] METHODS = {"rc4-md5", "aes-128-cfb", "aes-192-cfb", "aes-256-cfb", "des-cfb", "bf-cfb", "cast5-cfb", "chacha20", "salsa20"};
}
