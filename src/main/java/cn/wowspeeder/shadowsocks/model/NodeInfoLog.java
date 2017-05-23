package cn.wowspeeder.shadowsocks.model;

public class NodeInfoLog {
    private Integer id;

    private Integer nodeId;

    private Float uptime;

    private String load;

    private Integer logTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Float getUptime() {
        return uptime;
    }

    public void setUptime(Float uptime) {
        this.uptime = uptime;
    }

    public String getLoad() {
        return load;
    }

    public void setLoad(String load) {
        this.load = load == null ? null : load.trim();
    }

    public Integer getLogTime() {
        return logTime;
    }

    public void setLogTime(Integer logTime) {
        this.logTime = logTime;
    }
}