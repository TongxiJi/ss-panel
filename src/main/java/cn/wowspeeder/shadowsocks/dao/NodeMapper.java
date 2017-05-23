package cn.wowspeeder.shadowsocks.dao;

import cn.wowspeeder.shadowsocks.model.Node;
import cn.wowspeeder.shadowsocks.model.NodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface NodeMapper {
    int countByExample(NodeExample example);

    int deleteByExample(NodeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Node record);

    int insertSelective(Node record);

    List<Node> selectByExampleWithRowbounds(NodeExample example, RowBounds rowBounds);

    List<Node> selectByExample(NodeExample example);

    Node selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Node record, @Param("example") NodeExample example);

    int updateByExample(@Param("record") Node record, @Param("example") NodeExample example);

    int updateByPrimaryKeySelective(Node record);

    int updateByPrimaryKey(Node record);
}