package cn.wowspeeder.shadowsocks.model;

import cn.wowspeeder.shadowsocks.Application;
import cn.wowspeeder.shadowsocks.ext.Functions;
import cn.wowspeeder.shadowsocks.utils.DateKit;

public class User {
    private Integer id;

    private String userName;

    private String email;

    private String pass;

    private String passwd;

    private Integer t;

    private Long u;

    private Long d;

    private Long transferEnable;

    private Integer port;

    private String protocol;

    private String obfs;

    private Boolean switched = true;

    private Boolean enable = true;

    private Integer type;

    private Long lastGetGiftTime;

    private Long lastCheckInTime;

    private Long lastRestPassTime;

    private Long regDate;

    private Integer inviteNum;

    private Integer isAdmin;

    private Integer refBy;

    private Long expireTime;

    private String method;

    private Boolean isEmailVerify;

    private String regIp;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public Integer getT() {
        return t;
    }

    public void setT(Integer t) {
        this.t = t;
    }

    public Long getU() {
        return u;
    }

    public void setU(Long u) {
        this.u = u;
    }

    public Long getD() {
        return d;
    }

    public void setD(Long d) {
        this.d = d;
    }

    public Long getTransferEnable() {
        return transferEnable;
    }

    public void setTransferEnable(Long transferEnable) {
        this.transferEnable = transferEnable;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol == null ? null : protocol.trim();
    }

    public String getObfs() {
        return obfs;
    }

    public void setObfs(String obfs) {
        this.obfs = obfs == null ? null : obfs.trim();
    }

    public Boolean getSwitched() {
        return switched;
    }

    public void setSwitched(Boolean switched) {
        this.switched = switched;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getLastGetGiftTime() {
        return lastGetGiftTime;
    }

    public void setLastGetGiftTime(Long lastGetGiftTime) {
        this.lastGetGiftTime = lastGetGiftTime;
    }

    public Long getLastCheckInTime() {
        return lastCheckInTime;
    }

    public void setLastCheckInTime(Long lastCheckInTime) {
        this.lastCheckInTime = lastCheckInTime;
    }

    public Long getLastRestPassTime() {
        return lastRestPassTime;
    }

    public void setLastRestPassTime(Long lastRestPassTime) {
        this.lastRestPassTime = lastRestPassTime;
    }

    public Long getRegDate() {
        return regDate;
    }

    public void setRegDate(Long regDate) {
        this.regDate = regDate;
    }

    public Integer getInviteNum() {
        return inviteNum;
    }

    public void setInviteNum(Integer inviteNum) {
        this.inviteNum = inviteNum;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Integer getRefBy() {
        return refBy;
    }

    public void setRefBy(Integer refBy) {
        this.refBy = refBy;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Boolean getIsEmailVerify() {
        return isEmailVerify;
    }

    public void setIsEmailVerify(Boolean emailVerify) {
        isEmailVerify = emailVerify;
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp;
    }

    public double trafficUsagePercent() {
        long total = this.getU() + this.getD();
        long transferEnable = this.getTransferEnable();
        if (transferEnable == 0) {
            return 0;
        }
        long percent = total / transferEnable;
        percent = Math.round(percent) * 100;
        return percent;
    }

    public String enableTraffic() {
        return Functions.flowAutoShow(this.getTransferEnable());
    }

    public String usedTraffic() {
        return Functions.flowAutoShow(this.getU() + this.getD());
    }

    public String unusedTraffic() {
        long total = this.getU() + this.getD();
        long transfer_enable = this.getTransferEnable();
        return Functions.flowAutoShow(transfer_enable - total);
    }

    public String lastCheckInTime() {
        if (this.getLastCheckInTime() == 0) {
            return "从未签到";
        }
        return DateKit.formatDateByUnixTime(this.getLastCheckInTime(), "yyyy-MM-dd HH:mm:ss");
    }

    public boolean isAbleToCheckin() {
        Integer ct = Integer.valueOf(Application.getEnvValue("app.checkinTime")) * 60 * 60;
        if (this.getLastCheckInTime() + ct < DateKit.getCurrentUnixTime()) {
            return true;
        }
        return false;
    }

    public String lastSsTime() {
        if (this.getT() == 0) {
            return "从未使用喵";
        }
        return DateKit.formatDateByUnixTime(getT(), "yyyy-MM-dd HH:mm:ss");
    }

    public double enableTrafficInGB() {
        return transferEnable / (1048576 * 1024.0000);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", passwd='" + passwd + '\'' +
                ", t=" + t +
                ", u=" + u +
                ", d=" + d +
                ", transferEnable=" + transferEnable +
                ", port=" + port +
                ", protocol='" + protocol + '\'' +
                ", obfs='" + obfs + '\'' +
                ", switched=" + switched +
                ", enable=" + enable +
                ", type=" + type +
                ", lastGetGiftTime=" + lastGetGiftTime +
                ", lastCheckInTime=" + lastCheckInTime +
                ", lastRestPassTime=" + lastRestPassTime +
                ", regDate=" + regDate +
                ", inviteNum=" + inviteNum +
                ", isAdmin=" + isAdmin +
                ", refBy=" + refBy +
                ", expireTime=" + expireTime +
                ", method='" + method + '\'' +
                ", isEmailVerify=" + isEmailVerify +
                ", regIp='" + regIp + '\'' +
                '}';
    }
}