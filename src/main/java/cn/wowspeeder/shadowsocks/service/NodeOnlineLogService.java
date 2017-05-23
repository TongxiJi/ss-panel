package cn.wowspeeder.shadowsocks.service;


import cn.wowspeeder.shadowsocks.model.NodeOnlineLog;
import cn.wowspeeder.shadowsocks.model.NodeOnlineLogExample;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface NodeOnlineLogService {
	
	NodeOnlineLog getNodeOnlineLogById(Integer id);

	List<NodeOnlineLog> getNodeOnlineLogList(NodeOnlineLogExample example, RowBounds rowBounds);

	void update(NodeOnlineLog nodeOnlineLog) throws Exception;

	void save(NodeOnlineLog nodeOnlineLog) throws Exception;
	
	void delete(Integer id) throws Exception;
		
}
