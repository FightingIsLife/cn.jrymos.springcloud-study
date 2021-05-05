package cn.jrymos.eurekaclient.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class ProviderController {


    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${server.port}")
    private String port;



    @ResponseBody
    @RequestMapping("/info")
    public Map<String, String> getMap() {
        return new HashMap() {{
            put(applicationName, port);
        }};
    }



    @ResponseBody
    @RequestMapping("/timeout")
    public Map<String, String> timeout() throws InterruptedException {
        Random random = new Random();
        Thread.sleep((random.nextInt(12123) % 500) + 10);
        return new HashMap() {{
            put(applicationName, port);
        }};
    }
}
