package cn.wowspeeder.shadowsocks.service;

import cn.wowspeeder.shadowsocks.model.CheckinLog;
import cn.wowspeeder.shadowsocks.model.CheckinLogExample;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface CheckinLogService {
	
    void save(Integer user_id, int trafficToAdd);

    List<CheckinLog> getLogs(CheckinLogExample example, RowBounds rowBounds);
}
