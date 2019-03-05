package com.yao.ribbonservice.controller;

import com.yao.ribbonservice.service.HelloTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: ys1892
 * @Date: 2019-03-05
 * @Time: 13:49
 */
@RestController
public class HelloTestController {
    @Autowired
    private HelloTestService helloTestService;

    @GetMapping("/ribbonSayHello")
    public String say() {
        return helloTestService.say();
    }
}
