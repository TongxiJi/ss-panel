package cn.wowspeeder.shadowsocks.service;


import cn.wowspeeder.shadowsocks.model.User;
import cn.wowspeeder.shadowsocks.model.UserExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tonny Ji on 2017/5/23.
 */
public interface UserService {

    User getUserById(Integer uid);

    void update(User user);

    User byEmail(String email);

    int getIpRegCount(String ip);

    int getLastPort();

    void save(User user);

    List<User> getUsers(UserExample example, RowBounds rowBounds);

    void delete(Integer id);
}
