package com.yao.feignservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: ys1892
 * @Date: 2019-03-05
 * @Time: 9:48
 */
@RestController
@SuppressWarnings(value = "all")
public class HelloTestController {
    @Autowired
    private HelloFeign helloFeign;
    @GetMapping("/feignSayHello")
    public String say(){
        return helloFeign.say();
    }
}
