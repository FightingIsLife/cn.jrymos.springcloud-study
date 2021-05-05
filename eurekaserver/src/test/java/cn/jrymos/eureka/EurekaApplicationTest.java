package cn.jrymos.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 用来启动 8001
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaApplicationTest {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplicationTest.class, args);
    }

}
