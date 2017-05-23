package cn.wowspeeder.shadowsocks.service;


import cn.wowspeeder.shadowsocks.model.PasswordReset;

/**
 * Created by Tonny Ji on 2017/5/23.
 */
public interface PasswordResetService {

    void sendResetEmail(String email);

    PasswordReset byToken(String token);
}
