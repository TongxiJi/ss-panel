package cn.wowspeeder.shadowsocks.service.impl;


import cn.wowspeeder.shadowsocks.dao.LogMapper;
import cn.wowspeeder.shadowsocks.exception.TipException;
import cn.wowspeeder.shadowsocks.model.Log;
import cn.wowspeeder.shadowsocks.model.LogExample;
import cn.wowspeeder.shadowsocks.service.LogService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public Log getLogById(Integer id) {
        if (null == id) {
            return null;
        }
        return logMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Log> getLogList(LogExample example, RowBounds rowBounds) {
        return logMapper.selectByExampleWithRowbounds(example, rowBounds);
    }

    @Override
    public void save(Log log) throws Exception {
        if (null == log) {
            throw new TipException("对象为空");
        }
        try {
            logMapper.insert(log);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void update(Log log) throws Exception {
        if (null == log) {
            throw new TipException("对象为空");
        }
        try {
            logMapper.updateByPrimaryKey(log);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        if (null == id) {
            throw new TipException("主键为空");
        }
        try {
            logMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            throw e;
        }
    }

}
