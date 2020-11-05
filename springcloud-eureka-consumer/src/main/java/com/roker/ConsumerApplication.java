package com.roker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author Roker
 * @Date 2020/11/05 11:29
 * @Title ConsumerApplication
 * @Description 消费方 启动类
 */

@SpringBootApplication
@EnableEurekaClient
public class ConsumerApplication {

    public static void main(String[] args){
        SpringApplication.run(ConsumerApplication.class,args);
    }
}
