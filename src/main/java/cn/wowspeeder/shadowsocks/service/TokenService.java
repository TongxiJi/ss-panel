package cn.wowspeeder.shadowsocks.service;


import cn.wowspeeder.shadowsocks.model.UserToken;

/**
 * Created by biezhi on 2017/2/20.
 */
public interface TokenService {

    UserToken byToken(String token);

    String create(Integer id);

}
