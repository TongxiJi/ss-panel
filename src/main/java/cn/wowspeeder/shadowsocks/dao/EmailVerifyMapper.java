package cn.wowspeeder.shadowsocks.dao;

import cn.wowspeeder.shadowsocks.model.EmailVerify;
import cn.wowspeeder.shadowsocks.model.EmailVerifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface EmailVerifyMapper {
    int countByExample(EmailVerifyExample example);

    int deleteByExample(EmailVerifyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmailVerify record);

    int insertSelective(EmailVerify record);

    List<EmailVerify> selectByExampleWithRowbounds(EmailVerifyExample example, RowBounds rowBounds);

    List<EmailVerify> selectByExample(EmailVerifyExample example);

    EmailVerify selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmailVerify record, @Param("example") EmailVerifyExample example);

    int updateByExample(@Param("record") EmailVerify record, @Param("example") EmailVerifyExample example);

    int updateByPrimaryKeySelective(EmailVerify record);

    int updateByPrimaryKey(EmailVerify record);
}