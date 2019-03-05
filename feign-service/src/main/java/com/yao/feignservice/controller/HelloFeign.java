package com.yao.feignservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description:
 * @Author: ys1892
 * @Date: 2019-03-05
 * @Time: 9:49
 */
@FeignClient("hello-service")
public interface HelloFeign {
    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    String say();
}
