package cn.wowspeeder.shadowsocks.model;

public class NodeOnlineLog {
    private Integer id;

    private Integer nodeId;

    private Integer onlineUser;

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

    public Integer getOnlineUser() {
        return onlineUser;
    }

    public void setOnlineUser(Integer onlineUser) {
        this.onlineUser = onlineUser;
    }

    public Integer getLogTime() {
        return logTime;
    }

    public void setLogTime(Integer logTime) {
        this.logTime = logTime;
    }
}