package cn.wowspeeder.shadowsocks.service.impl;

import cn.wowspeeder.shadowsocks.Application;
import cn.wowspeeder.shadowsocks.common.SpConst;
import cn.wowspeeder.shadowsocks.dao.EmailVerifyMapper;
import cn.wowspeeder.shadowsocks.ext.Envelope;
import cn.wowspeeder.shadowsocks.model.EmailVerify;
import cn.wowspeeder.shadowsocks.model.EmailVerifyExample;
import cn.wowspeeder.shadowsocks.service.EmailVerifyService;
import cn.wowspeeder.shadowsocks.utils.DateKit;
import cn.wowspeeder.shadowsocks.utils.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class EmailVerifyServiceImpl implements EmailVerifyService {

    @Autowired
    private EmailVerifyMapper emailVerifyMapper;

    @Override
    public boolean checkVerifyCode(String email, String verifycode) {
        if (!StringUtils.isEmpty(email) && !StringUtils.isEmpty(verifycode)) {
            EmailVerifyExample emailVerifyExample = new EmailVerifyExample();
            emailVerifyExample.createCriteria()
                    .andEmailEqualTo(email);
            List<EmailVerify> emailVerifyList = emailVerifyMapper.selectByExample(emailVerifyExample);
            if (emailVerifyList == null || emailVerifyList.size() == 0) return false;

            EmailVerify emailVerify = emailVerifyList.get(0);
            if (null == emailVerify || emailVerify.getExpireAt() < DateKit.getCurrentUnixTime()
                    || !emailVerify.getToken().equals(verifycode)) {
                return false;
            }
            emailVerifyMapper.deleteByPrimaryKey(emailVerify.getId());
            return true;
        }
        return false;
    }

    @Override
    public void sendVerification(String email) {
        int ttl = Integer.parseInt(Application.getEnvValue("app.emailVerifyTTL"));
        EmailVerifyExample emailVerifyExample = new EmailVerifyExample();
        emailVerifyExample.createCriteria()
                .andEmailEqualTo(email);
        List<EmailVerify> emailVerifyList = emailVerifyMapper.selectByExample(emailVerifyExample);
        EmailVerify emailVerify = null;
        String token = null;
        if (emailVerifyList != null && emailVerifyList.size() != 0) {
            emailVerify = emailVerifyList.get(0);
            token = UUID.randomUUID().toString();
            long expire_at = DateKit.getCurrentUnixTime() + ttl;
            emailVerify.setToken(token);
            emailVerify.setExpireAt(expire_at);
        }

        if (null == emailVerify) {
            emailVerify = new EmailVerify();
            emailVerify.setEmail(email);
            emailVerifyMapper.insertSelective(emailVerify);
        } else {
            emailVerifyMapper.updateByPrimaryKeySelective(emailVerify);
        }

        String appName = Application.getEnvValue("app.appName");
        String subject = appName + " 邮箱验证";
        Map<String, Object> ary = new HashMap<>();
        ary.put("token", token);
        ary.put("ttl", ttl);
        ary.put("appName", appName);

        Envelope envelope = new Envelope(email, subject, "/auth/verify.html", ary);
        EmailUtils.send(envelope);
    }
}
