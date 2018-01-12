package cn.wowspeeder.shadowsocks.model;

public class CheckinLog {
    private Integer id;

    private Integer userId;

    private Long checkinAt;

    private Integer traffic;

    private Long createdAt;

    private Long updatedAt;

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

    public Long getCheckinAt() {
        return checkinAt;
    }

    public void setCheckinAt(Long checkinAt) {
        this.checkinAt = checkinAt;
    }

    public Integer getTraffic() {
        return traffic;
    }

    public void setTraffic(Integer traffic) {
        this.traffic = traffic;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }
}