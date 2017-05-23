package cn.wowspeeder.shadowsocks.dao;

import cn.wowspeeder.shadowsocks.model.PasswordReset;
import cn.wowspeeder.shadowsocks.model.PasswordResetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PasswordResetMapper {
    int countByExample(PasswordResetExample example);

    int deleteByExample(PasswordResetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PasswordReset record);

    int insertSelective(PasswordReset record);

    List<PasswordReset> selectByExampleWithRowbounds(PasswordResetExample example, RowBounds rowBounds);

    List<PasswordReset> selectByExample(PasswordResetExample example);

    PasswordReset selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PasswordReset record, @Param("example") PasswordResetExample example);

    int updateByExample(@Param("record") PasswordReset record, @Param("example") PasswordResetExample example);

    int updateByPrimaryKeySelective(PasswordReset record);

    int updateByPrimaryKey(PasswordReset record);
}