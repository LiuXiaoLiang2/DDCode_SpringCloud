package com.ddcode.openfeign.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/openfeign/provider")
    public String echo(@RequestParam("name") String name) {
        try {
            //加入超时
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "openfeign provider name : " + name + " , server port: " + serverPort;
    }
}
