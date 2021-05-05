package cn.jrymos.eurekaclient.consumer;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ErrorProviderClient implements ProviderClient {
    @Override
    public Map<String, String> getMap() {
        System.out.println("ErrorProviderClient");
        HashMap<String, String> map = new HashMap<>();
        map.put("ErrorProviderClient", "error");
        return map;
    }

    @Override
    public Map<String, String> timeout() {
        System.out.println("timeout");
        HashMap<String, String> map = new HashMap<>();
        map.put("ErrorProviderClient", "timeout");
        return map;
    }
}
