package com.roker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author Roker
 * @Date 2020/11/05 10:46
 * @Title ProviderApplication
 * @Description 服务提供者 启动类
 */

@SpringBootApplication
@EnableEurekaClient
public class ProviderApplication {
    public static void main(String[] args){
        SpringApplication.run(ProviderApplication.class,args);
    }
}
