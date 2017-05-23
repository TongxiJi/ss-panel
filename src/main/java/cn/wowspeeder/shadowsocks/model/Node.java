package cn.wowspeeder.shadowsocks.model;

public class Node {
    private Integer id;

    private String name;

    private Integer type;

    private String server;

    private String method;

    private Boolean customMethod;

    private Float trafficRate;

    private Integer onlineUserCount;

    private String trafficFromLogs;

    private Long nodeUptime;

    private String info;

    private String status;

    private Integer offset = 0;

    private Integer sort;

    private String nodeLoad;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server == null ? null : server.trim();
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method == null ? null : method.trim();
    }

    public Boolean getCustomMethod() {
        return customMethod;
    }

    public void setCustomMethod(Boolean customMethod) {
        this.customMethod = customMethod;
    }

    public Float getTrafficRate() {
        return trafficRate;
    }

    public void setTrafficRate(Float trafficRate) {
        this.trafficRate = trafficRate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getNodeLoad() {
        return nodeLoad;
    }

    public void setNodeLoad(String nodeLoad) {
        this.nodeLoad = nodeLoad;
    }

    public Integer getOnlineUserCount() {
        return onlineUserCount;
    }

    public void setOnlineUserCount(Integer onlineUserCount) {
        this.onlineUserCount = onlineUserCount;
    }

    public String getTrafficFromLogs() {
        return trafficFromLogs;
    }

    public void setTrafficFromLogs(String trafficFromLogs) {
        this.trafficFromLogs = trafficFromLogs;
    }

    public Long getNodeUptime() {
        return nodeUptime;
    }

    public void setNodeUptime(Long nodeUptime) {
        this.nodeUptime = nodeUptime;
    }
}