package cn.wowspeeder.shadowsocks.service;


import cn.wowspeeder.shadowsocks.model.Log;
import cn.wowspeeder.shadowsocks.model.LogExample;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface LogService {
	
	Log getLogById(Integer id);

	List<Log> getLogList(LogExample example, RowBounds rowBounds);

	void update(Log log) throws Exception;

	void save(Log log) throws Exception;
	
	void delete(Integer id) throws Exception;
		
}
