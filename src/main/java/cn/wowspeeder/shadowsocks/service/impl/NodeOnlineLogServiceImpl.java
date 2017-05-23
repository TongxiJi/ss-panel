package cn.wowspeeder.shadowsocks.service.impl;


import cn.wowspeeder.shadowsocks.dao.NodeOnlineLogMapper;
import cn.wowspeeder.shadowsocks.exception.TipException;
import cn.wowspeeder.shadowsocks.model.NodeOnlineLog;
import cn.wowspeeder.shadowsocks.model.NodeOnlineLogExample;
import cn.wowspeeder.shadowsocks.service.NodeOnlineLogService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeOnlineLogServiceImpl implements NodeOnlineLogService {

	@Autowired
	private NodeOnlineLogMapper nodeOnlineLogMapper;

	@Override
	public NodeOnlineLog getNodeOnlineLogById(Integer id) {
		if(null == id){
			return null;
		}
		return nodeOnlineLogMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<NodeOnlineLog> getNodeOnlineLogList(NodeOnlineLogExample example, RowBounds rowBounds) {
		return nodeOnlineLogMapper.selectByExampleWithRowbounds(example,rowBounds);
	}


	@Override
	public void save(NodeOnlineLog nodeOnlineLog) throws Exception {
		if(null == nodeOnlineLog){
			throw new TipException("对象为空");
		}
		try {
			nodeOnlineLogMapper.insert(nodeOnlineLog);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void update(NodeOnlineLog nodeOnlineLog) throws Exception {
		if(null == nodeOnlineLog){
			throw new TipException("对象为空");
		}
		try {
			nodeOnlineLogMapper.updateByPrimaryKey(nodeOnlineLog);
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
			nodeOnlineLogMapper.deleteByPrimaryKey(id);
		} catch (Exception e){
			throw e;
		}
	}
		
}
