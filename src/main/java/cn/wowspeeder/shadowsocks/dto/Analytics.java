package cn.wowspeeder.shadowsocks.dto;

import java.io.Serializable;

/**
 * Created by Tonny Ji on 2017/5/23.
 */
public class Analytics implements Serializable{

    private int users;
    private int nodes;
    private int checkInUsers;
    private double trafficUsage;
    private int online_users;

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }

    public int getNodes() {
        return nodes;
    }

    public void setNodes(int nodes) {
        this.nodes = nodes;
    }

    public int getCheckInUsers() {
        return checkInUsers;
    }

    public void setCheckInUsers(int checkInUsers) {
        this.checkInUsers = checkInUsers;
    }

    public double getTrafficUsage() {
        return trafficUsage;
    }

    public void setTrafficUsage(double trafficUsage) {
        this.trafficUsage = trafficUsage;
    }

    public int getOnline_users() {
        return online_users;
    }

    public void setOnline_users(int online_users) {
        this.online_users = online_users;
    }
}
