package cn.wowspeeder.shadowsocks.service;


import cn.wowspeeder.shadowsocks.model.InviteCode;
import cn.wowspeeder.shadowsocks.model.InviteCodeExample;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * Created by Tonny Ji on 2017/5/23.
 */
public interface InviteCodeService {

    List<InviteCode> getCodes(InviteCodeExample example);

    void saveCodes(Integer user_id, int num, String prefix);

    InviteCode byCode(String code);

    void delete(Integer id);
}