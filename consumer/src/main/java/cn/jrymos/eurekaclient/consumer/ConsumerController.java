package cn.jrymos.eurekaclient.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ConsumerController {

    private final ProviderClient providerClient;

    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${server.port}")
    private String port;



    @ResponseBody
    @RequestMapping("/{method}")
    public Map<String, String> getMap(@PathVariable("method") String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println(methodName);
        Method method = providerClient.getClass().getMethod(methodName);
        Map<String, String> map = (Map<String, String>) method.invoke(providerClient);
        map.put(applicationName, port);
        return map;
    }
}
