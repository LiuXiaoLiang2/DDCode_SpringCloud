package com.ddcode.gateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gateway")
public class Customer2Controller {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/getVersion")
    public String getVersion(){
        return "serverPort :" + serverPort + ", version , 2.0";
    }
}
