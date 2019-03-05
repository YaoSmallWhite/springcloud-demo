package com.yao.ribbonservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author: ys1892
 * @Date: 2019-03-05
 * @Time: 13:50
 */
@Service
public class HelloTestService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    public String say() {
        return restTemplate.getForObject("http://hello-service/sayHello", String.class);
    }

    private String error() {
        return "sorry,there is a problem!";
    }
}
