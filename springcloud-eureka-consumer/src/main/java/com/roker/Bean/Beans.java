package com.roker.Bean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Roker
 * @Date 2020/11/05 14:45
 * @Title Beans
 * @Description 组件注入
 */

@Configuration
public class Beans {
    //管理简单对象
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
