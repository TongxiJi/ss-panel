package cn.wowspeeder.shadowsocks.dto;


import cn.wowspeeder.shadowsocks.model.User;

/**
 * Created by Tonny Ji on 2017/5/23.
 */
public class LoginUser extends User {

    public LoginUser(User user) {
        setId(user.getId());
        setUserName(user.getUserName());
        setEmail(user.getEmail());
        setPass(user.getPass());
        setPasswd(user.getPasswd());
        setT(user.getT());
        setU(user.getU());
        setD(user.getD());
        setTransferEnable(user.getTransferEnable());
        setPort(user.getPort());
        setProtocol(user.getProtocol());
        setObfs(user.getObfs());
        setSwitched(user.getSwitched());
        setEnable(user.getEnable());
        setType(user.getType());
        setLastGetGiftTime(user.getLastGetGiftTime());
        setLastCheckInTime(user.getLastCheckInTime());
        setLastRestPassTime(user.getLastRestPassTime());
        setRegDate(user.getRegDate());
        setInviteNum(user.getInviteNum());
        setIsAdmin(user.getIsAdmin());
        setRefBy(user.getRefBy());
        setExpireTime(user.getExpireTime());
        setMethod(user.getMethod());
        setIsEmailVerify(user.getIsEmailVerify());
        setRegIp(user.getRegIp());
    }


}