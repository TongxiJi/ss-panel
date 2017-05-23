package cn.wowspeeder.shadowsocks.service.impl;


import cn.wowspeeder.shadowsocks.dao.CheckinLogMapper;
import cn.wowspeeder.shadowsocks.model.CheckinLog;
import cn.wowspeeder.shadowsocks.model.CheckinLogExample;
import cn.wowspeeder.shadowsocks.model.UserExample;
import cn.wowspeeder.shadowsocks.service.CheckinLogService;
import cn.wowspeeder.shadowsocks.utils.DateKit;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckinLogServiceImpl implements CheckinLogService {

	@Autowired
	private CheckinLogMapper checkinLogMapper;

	@Override
	public void save(Integer user_id, int trafficToAdd) {
		if(null != user_id && trafficToAdd > 0){
			CheckinLog checkinLog = new CheckinLog();
			checkinLog.setUserId(user_id);
			checkinLog.setTraffic(trafficToAdd);
			checkinLog.setCheckinAt(DateKit.getCurrentUnixTime());
			checkinLogMapper.insert(checkinLog);
		}
	}

	@Override
	public List<CheckinLog> getLogs(CheckinLogExample example, RowBounds rowBounds) {
		return checkinLogMapper.selectByExampleWithRowbounds(example,rowBounds);
	}
}
