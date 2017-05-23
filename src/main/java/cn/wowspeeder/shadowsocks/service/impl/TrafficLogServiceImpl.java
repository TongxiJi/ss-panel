package cn.wowspeeder.shadowsocks.service.impl;


import cn.wowspeeder.shadowsocks.dao.UserTrafficLogMapper;
import cn.wowspeeder.shadowsocks.exception.TipException;
import cn.wowspeeder.shadowsocks.model.UserTrafficLog;
import cn.wowspeeder.shadowsocks.model.UserTrafficLogExample;
import cn.wowspeeder.shadowsocks.service.TrafficLogService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrafficLogServiceImpl implements TrafficLogService {

	@Autowired
	private UserTrafficLogMapper trafficLogMapper;

	@Override
	public UserTrafficLog getTrafficLogById(Integer id) {
		if(null == id){
			return null;
		}
		return trafficLogMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<UserTrafficLog> getTrafficLogList(UserTrafficLogExample example, RowBounds rowBounds) {
		return trafficLogMapper.selectByExampleWithRowbounds(example, rowBounds);
	}
	
	@Override
	public void save(UserTrafficLog trafficLog) throws Exception {
		if(null == trafficLog){
			throw new TipException("对象为空");
		}
		try {
			trafficLogMapper.insert(trafficLog);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void update(UserTrafficLog trafficLog) throws Exception {
		if(null == trafficLog){
			throw new TipException("对象为空");
		}
		try {
			trafficLogMapper.updateByPrimaryKey(trafficLog);
		} catch (Exception e) {
			throw e;
		}
	}
	
	@Override
	public void delete(Integer id) throws Exception {
		if(null == id){
			throw new TipException("主键为空");
		}
		try {
			trafficLogMapper.deleteByPrimaryKey(id);
		} catch (Exception e){
			throw e;
		}
	}
}
