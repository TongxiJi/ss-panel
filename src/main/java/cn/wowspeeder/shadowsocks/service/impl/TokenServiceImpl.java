package cn.wowspeeder.shadowsocks.service.impl;


import cn.wowspeeder.shadowsocks.dao.UserTokenMapper;
import cn.wowspeeder.shadowsocks.exception.TipException;
import cn.wowspeeder.shadowsocks.model.UserToken;
import cn.wowspeeder.shadowsocks.model.UserTokenExample;
import cn.wowspeeder.shadowsocks.service.TokenService;
import cn.wowspeeder.shadowsocks.utils.DateKit;
import cn.wowspeeder.shadowsocks.utils.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by biezhi on 2017/2/20.
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private UserTokenMapper userTokenMapper;

    @Override
    public UserToken byToken(String token) {
        if (null != token) {
            UserTokenExample userTokenExample = new UserTokenExample();
            userTokenExample.createCriteria()
                    .andTokenEqualTo(token);
            List<UserToken> userTokens = userTokenMapper.selectByExample(userTokenExample);
            if (userTokens != null && userTokens.size() != 0) {
                return userTokens.get(0);
            }
        }
        return null;
    }

    @Override
    public String create(Integer uid) {
        if (null == uid) {
            throw new TipException("uid不能为空");
        }
        String token = UUID.UU32();
        UserToken t = new UserToken();
        t.setToken(token);
        t.setUserId(uid);
        long time = DateKit.getCurrentUnixTime();
        long exp = time + 3600 * 24 * 7;
        t.setCreateTime(time);
        t.setExpireTime(exp);
        userTokenMapper.insert(t);
        return token;
    }

    public static void main(String[] args) {
        System.out.println(UUID.UU32());
    }
}
