package com.yao.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: ys1892
 * @Date: 2019-03-05
 * @Time: 15:23
 */
@RestController
public class ConfigController {
    @Value("${address}")
    private String address;

    @GetMapping("/getConfig")
    public String getConfig() {
        return "get address=" + address + " from git ";
    }
}
