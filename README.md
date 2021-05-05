# cn.jrymos.springcloud-study
springcloud学习

## eurekaserver：
  启动EurekaApplication之后，访问 http://localhost:8002/ 
  （高可用）启动EurekaApplicationTest之后，访问 http://localhost:8001/ 

## provider：
  启动ProviderApplication之后，访问 http://localhost:8010/info 有效，在http://localhost:8002/ 和  http://localhost:8001/ 上能发现provider已经注册
  启动ProviderApplicationTest之后，访问 http://localhost:8011/info 有效，在http://localhost:8002/ 和  http://localhost:8001/ 上能发现provider注册了2台

## consumer：
  启动ConsumerApplication，访问http://localhost:8020/info有效，consumer也注册到了eureka
  启动ConsumerApplicationTest，访问http://localhost:8021/info有效，consumer注册了2台到eureka

## gateway：
  启动GatewayApplication，请求http://localhost/consumer/info 有效，请求会负载到其中一台consumer的/info接口
