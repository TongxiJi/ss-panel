package cn.wowspeeder.shadowsocks.service;


import cn.wowspeeder.shadowsocks.model.UserTrafficLog;
import cn.wowspeeder.shadowsocks.model.UserTrafficLogExample;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface TrafficLogService {
	
	UserTrafficLog getTrafficLogById(Integer id);

	List<UserTrafficLog> getTrafficLogList(UserTrafficLogExample example, RowBounds rowBounds);

	void update(UserTrafficLog trafficLog) throws Exception;

	void save(UserTrafficLog trafficLog) throws Exception;
	
	void delete(Integer id) throws Exception;

}
