package com.roker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Roker
 * @Date 2020/11/05 11:35
 * @Title ConsumerController
 * @Description consumer
 */

@RestController
@RequestMapping("/hello")
@Component
public class ConsumerController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/sayHello")
    public String sayHello(String name){
        System.out.println("传入的值为："+name);
        //第一种调用方式；RestTemplate
        String result1 = new RestTemplate().getForObject("http://localhost:8700/hello/sayHi?name=" + name, String.class);
        System.out.println(result1);

        //第二种调用方式 : 根据服务名 获取服务列表 根据算法选取某个服务 并访问某个服务的网络位置。
        ServiceInstance serviceInstance = loadBalancerClient.choose("SC-PROVIDER");
        System.out.println(serviceInstance);
        String result2 = new RestTemplate().getForObject("http://"+serviceInstance.getHost()+":"+serviceInstance.getPort()+"/hello/sayHi?name="+name,String.class);
        System.out.println(result2);

        //第三种调用方式 需要restTemplate注入的方式
        String result3 = restTemplate.getForObject("http://SC-PROVIDER/hello/sayHi?name=" + name, String.class);
        System.out.println(result3);

        return result2;
    }

}
