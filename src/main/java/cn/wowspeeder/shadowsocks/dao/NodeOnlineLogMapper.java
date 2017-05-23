package cn.wowspeeder.shadowsocks.dao;

import cn.wowspeeder.shadowsocks.model.NodeOnlineLog;
import cn.wowspeeder.shadowsocks.model.NodeOnlineLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface NodeOnlineLogMapper {
    int countByExample(NodeOnlineLogExample example);

    int deleteByExample(NodeOnlineLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NodeOnlineLog record);

    int insertSelective(NodeOnlineLog record);

    List<NodeOnlineLog> selectByExampleWithRowbounds(NodeOnlineLogExample example, RowBounds rowBounds);

    List<NodeOnlineLog> selectByExample(NodeOnlineLogExample example);

    NodeOnlineLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NodeOnlineLog record, @Param("example") NodeOnlineLogExample example);

    int updateByExample(@Param("record") NodeOnlineLog record, @Param("example") NodeOnlineLogExample example);

    int updateByPrimaryKeySelective(NodeOnlineLog record);

    int updateByPrimaryKey(NodeOnlineLog record);
}