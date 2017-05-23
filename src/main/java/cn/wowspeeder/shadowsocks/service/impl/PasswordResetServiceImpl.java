package cn.wowspeeder.shadowsocks.service.impl;


import cn.wowspeeder.shadowsocks.common.SpConst;
import cn.wowspeeder.shadowsocks.dao.PasswordResetMapper;
import cn.wowspeeder.shadowsocks.ext.Envelope;
import cn.wowspeeder.shadowsocks.ext.Functions;
import cn.wowspeeder.shadowsocks.model.PasswordReset;
import cn.wowspeeder.shadowsocks.model.PasswordResetExample;
import cn.wowspeeder.shadowsocks.service.PasswordResetService;
import cn.wowspeeder.shadowsocks.utils.DateKit;
import cn.wowspeeder.shadowsocks.utils.EmailUtils;
import cn.wowspeeder.shadowsocks.utils.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Tonny Ji on 2017/5/23.
 */
@Service
public class PasswordResetServiceImpl implements PasswordResetService {

    @Autowired
    private PasswordResetMapper passwordResetMapper;

    @Override
    public void sendResetEmail(String email) {
        PasswordReset passwordReset = new PasswordReset();
        passwordReset.setEmail(email);
        String token = UUID.UU16();
        passwordReset.setToken(token);
        int time = DateKit.getCurrentUnixTime();
        passwordReset.setInitTime(time);
        passwordReset.setExpireTime(time + 3600 * 24);
        passwordResetMapper.insert(passwordReset);

        String subject = Functions.config("app.appName") + " 重置密码";

        String resetUrl = SpConst.SITE_URL + "/password/token?c=" + token;
        Map<String, Object> cry = new HashMap<>();
        cry.put("resetUrl", resetUrl);
        cry.put("appName", Functions.config("app.appName"));

        Envelope envelope = new Envelope(email, "/email/password/reset.html", subject, cry);
        EmailUtils.send(envelope);

    }

    @Override
    public PasswordReset byToken(String token) {
        if (!StringUtils.isEmpty(token)) {
            PasswordResetExample passwordResetExample = new PasswordResetExample();
            passwordResetExample.createCriteria()
                    .andTokenEqualTo(token);
            List<PasswordReset> passwordResets = passwordResetMapper.selectByExample(passwordResetExample);
            if (passwordResets != null && passwordResets.size() != 0)
                return passwordResets.get(0);
        }
        return null;
    }
}
