package cn.wowspeeder.shadowsocks.service;

import java.util.List;
import java.util.Map;

public interface ConfigService {

    Map<String, String> getConfigs(List<String> keys);

	String getConfig(String key);

    void updateByKey(String key, String value);
}
