package cn.wowspeeder.shadowsocks.dto;


import cn.wowspeeder.shadowsocks.model.Node;
import cn.wowspeeder.shadowsocks.model.NodeInfoLog;

/**
 * Created by Tonny Ji on 2017/5/23.
 */
public class NodeDto extends Node {

    private NodeInfoLog log;

    public String getNodeLoad(){
        if(null == log){
            return "暂无数据";
        }
        return log.getLoad();
    }

    public NodeInfoLog getLastNodeInfoLog(){
        return log;
    }

    public void setLog(NodeInfoLog log) {
        this.log = log;
    }

}
