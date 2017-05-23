package cn.wowspeeder.shadowsocks.service;


import cn.wowspeeder.shadowsocks.dto.Analytics;

/**
 * Created by Tonny Ji on 2017/5/23.
 */
public interface AdminService {

    Analytics getAnalytics(int time);

}
