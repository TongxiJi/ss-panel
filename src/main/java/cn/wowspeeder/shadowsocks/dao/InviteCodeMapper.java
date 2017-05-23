package cn.wowspeeder.shadowsocks.dao;

import cn.wowspeeder.shadowsocks.model.InviteCode;
import cn.wowspeeder.shadowsocks.model.InviteCodeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface InviteCodeMapper {
    int countByExample(InviteCodeExample example);

    int deleteByExample(InviteCodeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InviteCode record);

    int insertSelective(InviteCode record);

    List<InviteCode> selectByExampleWithRowbounds(InviteCodeExample example, RowBounds rowBounds);

    List<InviteCode> selectByExample(InviteCodeExample example);

    InviteCode selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InviteCode record, @Param("example") InviteCodeExample example);

    int updateByExample(@Param("record") InviteCode record, @Param("example") InviteCodeExample example);

    int updateByPrimaryKeySelective(InviteCode record);

    int updateByPrimaryKey(InviteCode record);
}