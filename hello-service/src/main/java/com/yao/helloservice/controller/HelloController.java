package com.yao.helloservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: ys1892
 * @Date: 2019-03-05
 * @Time: 9:00
 */
@RestController
public class HelloController {
    @Value("${server.port}")
    private int port;
    @GetMapping("/sayHello")
    public String sayHello(){
        return "hello,i'm from port:"+port;
    }

}
