package cn.wowspeeder.shadowsocks.dao;

import cn.wowspeeder.shadowsocks.model.NodeInfoLog;
import cn.wowspeeder.shadowsocks.model.NodeInfoLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface NodeInfoLogMapper {
    int countByExample(NodeInfoLogExample example);

    int deleteByExample(NodeInfoLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NodeInfoLog record);

    int insertSelective(NodeInfoLog record);

    List<NodeInfoLog> selectByExampleWithRowbounds(NodeInfoLogExample example, RowBounds rowBounds);

    List<NodeInfoLog> selectByExample(NodeInfoLogExample example);

    NodeInfoLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NodeInfoLog record, @Param("example") NodeInfoLogExample example);

    int updateByExample(@Param("record") NodeInfoLog record, @Param("example") NodeInfoLogExample example);

    int updateByPrimaryKeySelective(NodeInfoLog record);

    int updateByPrimaryKey(NodeInfoLog record);
}