package cn.wowspeeder.shadowsocks.service;


import cn.wowspeeder.shadowsocks.model.NodeInfoLog;
import cn.wowspeeder.shadowsocks.model.NodeInfoLogExample;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface NodeInfoLogService {
	
	NodeInfoLog getNodeInfoLogById(Integer id);

	List<NodeInfoLog> getNodeInfoLogList(NodeInfoLogExample example, RowBounds rowBounds);

	void update(NodeInfoLog nodeInfoLog) throws Exception;

	void save(NodeInfoLog nodeInfoLog) throws Exception;
	
	void delete(Integer id) throws Exception;
		
}
