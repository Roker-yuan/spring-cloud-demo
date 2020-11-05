package com.roker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Roker
 * @Date 2020/11/05 10:53
 * @Title ProviderController
 * @Description controller
 */

@RestController
@RequestMapping("/hello")
public class ProviderController {

    @GetMapping("/sayHi")
    public String sayHi(String name){
        System.out.println("传入的值为：" + name);
        return "Provider-say hi to " + name;
    }
}
