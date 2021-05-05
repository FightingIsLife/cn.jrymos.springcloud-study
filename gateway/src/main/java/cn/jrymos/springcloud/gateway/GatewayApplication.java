package cn.jrymos.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
            .route(r -> r.path("/")
                .uri("https://localhost:8001/"))
            .route(r -> r.path("/get")
                .filters(f -> f.rewritePath("/consumer/(?<segment>.*)", "/${segment}"))
                .uri("lb://consumer"))
            .route(r -> r.path("/provider/**")
                .filters(f -> f.rewritePath("/provider/(?<segment>.*)", "/${segment}"))
                .uri("lb://provider"))
            .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

}
