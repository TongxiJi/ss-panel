package cn.wowspeeder.shadowsocks.service.impl;


import cn.wowspeeder.shadowsocks.dao.UserMapper;
import cn.wowspeeder.shadowsocks.model.User;
import cn.wowspeeder.shadowsocks.model.UserExample;
import cn.wowspeeder.shadowsocks.service.UserService;
import cn.wowspeeder.shadowsocks.utils.DateKit;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by Tonny Ji on 2017/5/23.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Integer uid) {
        if (null != uid) {
            return userMapper.selectByPrimaryKey(uid);
        }
        return null;
    }

    @Override
    public void update(User user) {
        if (null != user && null != user.getId()) {
            userMapper.updateByPrimaryKeySelective(user);
        }
    }

    @Override
    public User byEmail(String email) {
        if (!StringUtils.isEmpty(email)) {
            UserExample userExample = new UserExample();
            userExample
                    .createCriteria()
                    .andEmailEqualTo(email);
            List<User> users = userMapper.selectByExample(userExample);
            if (users != null && users.size() > 0) {
                return users.get(0);
            }
        }
        return null;
    }

    @Override
    public int getIpRegCount(String ip) {
        if (!StringUtils.isEmpty(ip)) {
            UserExample userExample = new UserExample();
            userExample.createCriteria()
                    .andRegIpEqualTo(ip)
                    .andRegDateGreaterThan(DateKit.getCurrentUnixTime());
            return userMapper.countByExample(userExample);
        }
        return 0;
    }

    @Override
    public int getLastPort() {
        int port = userMapper.getLastPort();
        if (0 == port) {
            port = 1024;
        }
        return port;
    }

    @Override
    public void save(User user) {
        if (null != user) {
            userMapper.insert(user);
        }
    }

    @Override
    public List<User> getUsers(UserExample example, RowBounds rowBounds) {
        return userMapper.selectByExampleWithRowbounds(example,rowBounds);
    }

    @Override
    public void delete(Integer id) {
        if (null != id) {
            userMapper.deleteByPrimaryKey(id);
        }
    }

}
