package cn.wowspeeder.shadowsocks.dao;

import cn.wowspeeder.shadowsocks.model.User;
import cn.wowspeeder.shadowsocks.model.UserExample;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author:TongxiJi E-MAIL:694270875@qq.com
 * Function:
 * Create Date:五月04,2017
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/application-dao.xml "})
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelectByPrimaryKey() throws Exception {
        int id = 1;
        User user = userMapper.selectByPrimaryKey(id);
        System.out.println("额度撒大所多");
        System.out.println(user.toString());
    }

    @Test
    public void testSelectByExample() throws Exception {
        List<User> users = userMapper.selectByExampleWithRowbounds(
                new UserExample(), new RowBounds(0,10));
        for (User user : users) {
            System.out.println(user.toString());
        }

    }
}