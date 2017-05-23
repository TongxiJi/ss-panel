package cn.wowspeeder.shadowsocks.dao;

import cn.wowspeeder.shadowsocks.model.Log;
import cn.wowspeeder.shadowsocks.model.LogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LogMapper {
    int countByExample(LogExample example);

    int deleteByExample(LogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Log record);

    int insertSelective(Log record);

    List<Log> selectByExampleWithBLOBsWithRowbounds(LogExample example, RowBounds rowBounds);

    List<Log> selectByExampleWithBLOBs(LogExample example);

    List<Log> selectByExampleWithRowbounds(LogExample example, RowBounds rowBounds);

    List<Log> selectByExample(LogExample example);

    Log selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Log record, @Param("example") LogExample example);

    int updateByExampleWithBLOBs(@Param("record") Log record, @Param("example") LogExample example);

    int updateByExample(@Param("record") Log record, @Param("example") LogExample example);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKeyWithBLOBs(Log record);

    int updateByPrimaryKey(Log record);
}