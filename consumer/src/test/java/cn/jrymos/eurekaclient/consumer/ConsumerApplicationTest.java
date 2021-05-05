package cn.jrymos.eurekaclient.consumer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableHystrix
@SpringBootApplication
public class ConsumerApplicationTest {


    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplicationTest.class, args);
    }
}