package cn.jrymos.eurekaclient.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@FeignClient(value = "provider", fallback = ErrorProviderClient.class)
public interface ProviderClient {

    @ResponseBody
    @RequestMapping("/info")
    Map<String, String> getMap();


    @ResponseBody
    @RequestMapping("/timeout")
    Map<String, String> timeout();
}
