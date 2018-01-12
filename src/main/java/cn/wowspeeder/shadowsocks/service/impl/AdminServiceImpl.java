package cn.wowspeeder.shadowsocks.service.impl;


import cn.wowspeeder.shadowsocks.dao.NodeMapper;
import cn.wowspeeder.shadowsocks.dao.UserMapper;
import cn.wowspeeder.shadowsocks.dto.Analytics;
import cn.wowspeeder.shadowsocks.model.UserExample;
import cn.wowspeeder.shadowsocks.service.AdminService;
import cn.wowspeeder.shadowsocks.utils.DateKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Tonny Ji on 2017/5/23.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private NodeMapper nodeMapper;


    /**
     * @param time
     * @return
     */
    @Override
    public Analytics getAnalytics(int time) {
        Analytics analytics = new Analytics();

        Long todayUnixTime = Timestamp.valueOf(LocalDate.now().atStartOfDay()).getTime() / 1000;

        //总用户
        int users = userMapper.countByExample(null);
        //节点数
        int nodes = nodeMapper.countByExample(null);
        //今天签到的玩家
        UserExample checkInExample = new UserExample();
        checkInExample.createCriteria()
                .andLastCheckInTimeGreaterThan(todayUnixTime);
        int checkInUsers = userMapper.countByExample(checkInExample);

        // TODO: 2017/5/23 @param time 内在线的用户
        long t = DateKit.getCurrentUnixTime() - time;
//        UserExample onlineExample = new UserExample();
//        onlineExample.createCriteria()
//                .andTGreaterThan(t);
        int online_users = 0;//userMapper.countByExample(checkInExample);

        analytics.setUsers(users);
        analytics.setNodes(nodes);
        analytics.setCheckInUsers(checkInUsers);
        analytics.setOnline_users(online_users);

        return analytics;
    }
}
