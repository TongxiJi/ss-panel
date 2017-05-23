package cn.wowspeeder.shadowsocks.service;

public interface EmailVerifyService {
	
    boolean checkVerifyCode(String email, String verifycode);

    void sendVerification(String email);
}
