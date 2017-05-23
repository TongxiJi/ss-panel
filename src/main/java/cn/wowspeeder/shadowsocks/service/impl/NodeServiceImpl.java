package cn.wowspeeder.shadowsocks.service.impl;


import cn.wowspeeder.shadowsocks.dao.NodeMapper;
import cn.wowspeeder.shadowsocks.model.Node;
import cn.wowspeeder.shadowsocks.model.NodeExample;
import cn.wowspeeder.shadowsocks.service.NodeService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tonny Ji on 2017/5/23.
 */
@Service
public class NodeServiceImpl implements NodeService {

    @Autowired
    private NodeMapper nodeMapper;

    @Override
    public List<Node> getNodes(NodeExample example, RowBounds rowBounds) {
        return nodeMapper.selectByExampleWithRowbounds(example, rowBounds);
    }

    @Override
    public Node byId(Integer id) {
        if (null != id) {
            return nodeMapper.selectByPrimaryKey(id);
        }
        return null;
    }

    @Override
    public void save(Node node) {
        if (null != node) {
            nodeMapper.insert(node);
        }
    }

    @Override
    public void update(Node node) {
        if (null != node && null != node.getId()) {
            nodeMapper.updateByPrimaryKey(node);
        }
    }

    @Override
    public void delete(Integer id) {
        if (null != id) {
            nodeMapper.deleteByPrimaryKey(id);
        }
    }
}
