package cn.wowspeeder.shadowsocks.service.impl;

import cn.wowspeeder.shadowsocks.dao.InviteCodeMapper;
import cn.wowspeeder.shadowsocks.model.InviteCode;
import cn.wowspeeder.shadowsocks.model.InviteCodeExample;
import cn.wowspeeder.shadowsocks.service.InviteCodeService;
import cn.wowspeeder.shadowsocks.utils.DateKit;
import cn.wowspeeder.shadowsocks.utils.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by Tonny Ji on 2017/5/23.
 */
@Service
public class InviteCodeServiceImpl implements InviteCodeService {

    @Autowired
    private InviteCodeMapper inviteCodeMapper;

    @Override
    public List<InviteCode> getCodes(InviteCodeExample example) {
        return inviteCodeMapper.selectByExample(example);
    }

    @Override
    public void saveCodes(Integer user_id, int num, String prefix) {
        for (int i = 0; i < num; i++) {
            String code = prefix + UUID.UU64();
            InviteCode inviteCode = new InviteCode();
            inviteCode.setCode(code);
            inviteCode.setUserId(user_id);
            inviteCode.setCreatedAt(DateKit.getCurrentUnixTime());
            inviteCode.setUpdatedAt(DateKit.getCurrentUnixTime());
            inviteCodeMapper.insert(inviteCode);
        }
    }

    @Override
    public InviteCode byCode(String code) {
        if (!StringUtils.isEmpty(code)) {
            InviteCodeExample inviteCodeExample = new InviteCodeExample();
            inviteCodeExample.createCriteria()
                    .andCodeEqualTo(code);
            List<InviteCode> inviteCodes = inviteCodeMapper.selectByExample(inviteCodeExample);
            if (inviteCodes != null && inviteCodes.size() != 0) {
                return inviteCodes.get(0);
            }
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        if (null != id) {
            inviteCodeMapper.deleteByPrimaryKey(id);
        }
    }

}
