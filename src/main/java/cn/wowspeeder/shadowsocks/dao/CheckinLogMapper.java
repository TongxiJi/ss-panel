package cn.wowspeeder.shadowsocks.dao;

import cn.wowspeeder.shadowsocks.model.CheckinLog;
import cn.wowspeeder.shadowsocks.model.CheckinLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CheckinLogMapper {
    int countByExample(CheckinLogExample example);

    int deleteByExample(CheckinLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CheckinLog record);

    int insertSelective(CheckinLog record);

    List<CheckinLog> selectByExampleWithRowbounds(CheckinLogExample example, RowBounds rowBounds);

    List<CheckinLog> selectByExample(CheckinLogExample example);

    CheckinLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CheckinLog record, @Param("example") CheckinLogExample example);

    int updateByExample(@Param("record") CheckinLog record, @Param("example") CheckinLogExample example);

    int updateByPrimaryKeySelective(CheckinLog record);

    int updateByPrimaryKey(CheckinLog record);
}