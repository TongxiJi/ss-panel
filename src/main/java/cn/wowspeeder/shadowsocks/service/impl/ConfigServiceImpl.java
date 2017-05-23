package cn.wowspeeder.shadowsocks.service.impl;

import cn.wowspeeder.shadowsocks.dao.ConfigMapper;
import cn.wowspeeder.shadowsocks.model.Config;
import cn.wowspeeder.shadowsocks.model.ConfigExample;
import cn.wowspeeder.shadowsocks.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private ConfigMapper configMapper;

    @Override
    public String getConfig(String key) {
        ConfigExample example = new ConfigExample();
        example.createCriteria()
                .andKeyEqualTo(key);
        List<Config> configs = configMapper.selectByExample(example);
        if (configs != null && !configs.isEmpty()) {
            return configs.get(0).getValue();
        }
        return "";
    }

    @Override
    public Map<String, String> getConfigs(List<String> keys) {
        Map<String, String> map = new HashMap<>();
        ConfigExample example = new ConfigExample();
        example.createCriteria()
                .andKeyIn(keys);

        List<Config> list = configMapper.selectByExample(example);
        if (null != list) {
            for (Config config : list) {
                map.put(config.getKey(), config.getValue());
            }
        }
        return map;
    }

    @Override
    public void updateByKey(String key, String value) {
        if (!StringUtils.isEmpty(key) && !StringUtils.isEmpty(value)) {
            ConfigExample example = new ConfigExample();
            example.createCriteria()
                    .andKeyEqualTo(key);

            Config config = new Config();
            config.setValue(value);

            configMapper.updateByExampleSelective(config,example);
        }
    }
}
