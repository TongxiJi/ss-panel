package cn.wowspeeder.shadowsocks.dao;

import cn.wowspeeder.shadowsocks.model.UserTrafficLog;
import cn.wowspeeder.shadowsocks.model.UserTrafficLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserTrafficLogMapper {
    int countByExample(UserTrafficLogExample example);

    int deleteByExample(UserTrafficLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserTrafficLog record);

    int insertSelective(UserTrafficLog record);

    List<UserTrafficLog> selectByExampleWithRowbounds(UserTrafficLogExample example, RowBounds rowBounds);

    List<UserTrafficLog> selectByExample(UserTrafficLogExample example);

    UserTrafficLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserTrafficLog record, @Param("example") UserTrafficLogExample example);

    int updateByExample(@Param("record") UserTrafficLog record, @Param("example") UserTrafficLogExample example);

    int updateByPrimaryKeySelective(UserTrafficLog record);

    int updateByPrimaryKey(UserTrafficLog record);
}