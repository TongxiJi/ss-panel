package cn.wowspeeder.shadowsocks.dao;

import cn.wowspeeder.shadowsocks.model.UserToken;
import cn.wowspeeder.shadowsocks.model.UserTokenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserTokenMapper {
    int countByExample(UserTokenExample example);

    int deleteByExample(UserTokenExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserToken record);

    int insertSelective(UserToken record);

    List<UserToken> selectByExampleWithRowbounds(UserTokenExample example, RowBounds rowBounds);

    List<UserToken> selectByExample(UserTokenExample example);

    UserToken selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserToken record, @Param("example") UserTokenExample example);

    int updateByExample(@Param("record") UserToken record, @Param("example") UserTokenExample example);

    int updateByPrimaryKeySelective(UserToken record);

    int updateByPrimaryKey(UserToken record);
}