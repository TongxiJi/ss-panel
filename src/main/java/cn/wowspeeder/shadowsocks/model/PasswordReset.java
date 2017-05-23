package cn.wowspeeder.shadowsocks.model;

public class PasswordReset {
    private Integer id;

    private String email;

    private String token;

    private Integer initTime;

    private Integer expireTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Integer getInitTime() {
        return initTime;
    }

    public void setInitTime(Integer initTime) {
        this.initTime = initTime;
    }

    public Integer getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Integer expireTime) {
        this.expireTime = expireTime;
    }
}