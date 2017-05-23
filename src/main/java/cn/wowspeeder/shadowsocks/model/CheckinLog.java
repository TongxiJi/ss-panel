package cn.wowspeeder.shadowsocks.model;

public class CheckinLog {
    private Integer id;

    private Integer userId;

    private Integer checkinAt;

    private Integer traffic;

    private Integer createdAt;

    private Integer updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCheckinAt() {
        return checkinAt;
    }

    public void setCheckinAt(Integer checkinAt) {
        this.checkinAt = checkinAt;
    }

    public Integer getTraffic() {
        return traffic;
    }

    public void setTraffic(Integer traffic) {
        this.traffic = traffic;
    }

    public Integer getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Integer createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Integer updatedAt) {
        this.updatedAt = updatedAt;
    }
}