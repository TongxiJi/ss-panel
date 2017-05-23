package cn.wowspeeder.shadowsocks.service.impl;


import cn.wowspeeder.shadowsocks.dao.NodeInfoLogMapper;
import cn.wowspeeder.shadowsocks.exception.TipException;
import cn.wowspeeder.shadowsocks.model.NodeInfoLog;
import cn.wowspeeder.shadowsocks.model.NodeInfoLogExample;
import cn.wowspeeder.shadowsocks.service.NodeInfoLogService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeInfoLogServiceImpl implements NodeInfoLogService {

    @Autowired
    private NodeInfoLogMapper nodeInfoLogMapper;

    @Override
    public NodeInfoLog getNodeInfoLogById(Integer id) {
        if (null == id) {
            return null;
        }
        return nodeInfoLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<NodeInfoLog> getNodeInfoLogList(NodeInfoLogExample example, RowBounds rowBounds) {
        return nodeInfoLogMapper.selectByExampleWithRowbounds(example, rowBounds);
    }

    @Override
    public void save(NodeInfoLog nodeInfoLog) throws Exception {
        if (null == nodeInfoLog) {
            throw new TipException("对象为空");
        }
        try {
            nodeInfoLogMapper.insert(nodeInfoLog);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void update(NodeInfoLog nodeInfoLog) throws Exception {
        if (null == nodeInfoLog) {
            throw new TipException("对象为空");
        }
        try {
            nodeInfoLogMapper.updateByPrimaryKey(nodeInfoLog);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        if (null == id) {
            throw new TipException("主键为空");
        }
        try {
            nodeInfoLogMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            throw e;
        }
    }

}
