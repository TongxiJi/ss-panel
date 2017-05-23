package cn.wowspeeder.shadowsocks.service;


import cn.wowspeeder.shadowsocks.model.Node;
import cn.wowspeeder.shadowsocks.model.NodeExample;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created by Tonny Ji on 2017/5/23.
 */
public interface NodeService {

    List<Node> getNodes(NodeExample example, RowBounds rowBounds);

    Node byId(Integer id);

    void save(Node node);

    void update(Node node);

    void delete(Integer id);
}
