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

    private Byte switched;

    private Byte enable;

    private Byte type;

    private Integer lastGetGiftTime;

    private Integer lastCheckInTime;

    private Integer lastRestPassTime;

    private Integer regDate;

    private Integer inviteNum;

    private Integer isAdmin;

    private Integer refBy;

    private Integer expireTime;

    private String method;

    private Byte isEmailVerify;

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

    public Byte getSwitched() {
        return switched;
    }

    public void setSwitched(Byte switched) {
        this.switched = switched;
    }

    public Byte getEnable() {
        return enable;
    }

    public void setEnable(Byte enable) {
        this.enable = enable;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getLastGetGiftTime() {
        return lastGetGiftTime;
    }

    public void setLastGetGiftTime(Integer lastGetGiftTime) {
        this.lastGetGiftTime = lastGetGiftTime;
    }

    public Integer getLastCheckInTime() {
        return lastCheckInTime;
    }

    public void setLastCheckInTime(Integer lastCheckInTime) {
        this.lastCheckInTime = lastCheckInTime;
    }

    public Integer getLastRestPassTime() {
        return lastRestPassTime;
    }

    public void setLastRestPassTime(Integer lastRestPassTime) {
        this.lastRestPassTime = lastRestPassTime;
    }

    public Integer getRegDate() {
        return regDate;
    }

    public void setRegDate(Integer regDate) {
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

    public Integer getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Integer expireTime) {
        this.expireTime = expireTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public Byte getIsEmailVerify() {
        return isEmailVerify;
    }

    public void setIsEmailVerify(Byte isEmailVerify) {
        this.isEmailVerify = isEmailVerify;
    }

    public String getRegIp() {
        return regIp;
    }

    public void setRegIp(String regIp) {
        this.regIp = regIp == null ? null : regIp.trim();
    }

    public double trafficUsagePercent(){
        long total = this.getU() + this.getD();
        long transferEnable = this.getTransferEnable();
        if(transferEnable == 0){
            return 0;
        }
        long percent = total / transferEnable;
        percent = Math.round(percent) * 100;
        return percent;
    }

    public String enableTraffic(){
        return Functions.flowAutoShow(this.getTransferEnable());
    }

    public String usedTraffic(){
        return Functions.flowAutoShow(this.getU() + this.getD());
    }

    public String unusedTraffic(){
        long total = this.getU() + this.getD();
        long transfer_enable = this.getTransferEnable();
        return Functions.flowAutoShow(transfer_enable - total);
    }

    public String lastCheckInTime(){
        if(this.getLastCheckInTime() == 0){
            return "从未签到";
        }
        return DateKit.formatDateByUnixTime(this.getLastCheckInTime(), "yyyy-MM-dd HH:mm:ss");
    }

    public boolean isAbleToCheckin(){
        Integer ct = Integer.valueOf(Application.getEnvValue("app.checkinTime")) * 60 * 60;
        if(this.getLastCheckInTime() + ct < DateKit.getCurrentUnixTime()){
            return true;
        }
        return false;
    }

    public String lastSsTime(){
        if(this.getT() == 0){
            return "从未使用喵";
        }
        return DateKit.formatDateByUnixTime(getT(), "yyyy-MM-dd HH:mm:ss");
    }

    public double enableTrafficInGB() {
        return transferEnable /(1048576 * 1024.0000);
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