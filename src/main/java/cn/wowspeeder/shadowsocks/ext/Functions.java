package cn.wowspeeder.shadowsocks.ext;

import cn.wowspeeder.shadowsocks.Application;
import cn.wowspeeder.shadowsocks.utils.DateKit;
import cn.wowspeeder.shadowsocks.utils.Utils;
import jetbrick.util.codec.MD5Utils;
import org.springframework.util.StringUtils;

import java.util.Random;

/**
 * Created by Tonny Ji on 2017/5/23.
 */
public class Functions {

    public static String config(String key) {
        if (!StringUtils.isEmpty(key)) {
            return Application.getEnvValue(key);
        }
        return "";
    }

    /**
     * 取某个区间的随机数
     *
     * @param max
     * @return
     */
    public static int random(int max) {
        int min = 1;
        Random random = new Random();
        int radom = random.nextInt(max) % (max - min + 1) + min;
        if (radom == 0) {
            return 1;
        }
        return radom;
    }

    /**
     * 格式化日期
     *
     * @param unixTime
     * @return
     */
    public static String fmtdate(Long unixTime) {
        if (null != unixTime) {
            return DateKit.formatDateByUnixTime(unixTime, "yyyy-MM-dd");
        }
        return "";
    }

    /**
     * 格式化日期
     *
     * @param unixTime
     * @param patten
     * @return
     */
    public static String fmtdate(Long unixTime, String patten) {
        if (null != unixTime && !StringUtils.isEmpty(patten)) {
            return DateKit.formatDateByUnixTime(unixTime, patten);
        }
        return "";
    }

    public static String flowAutoShow(long s) {
        return Utils.flowAutoShow(s);
    }

    public static String gavatar(String email) {
        String hash = MD5Utils.md5Hex(email.trim().toLowerCase());
        return "https://secure.gravatar.com/avatar/" + hash;
    }

}
