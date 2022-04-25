package com.ddcode.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    @Value("${user.name}")
    private String userName;

    @Value("${user.pwd}")
    private String userPwd;

    @Value("${branch}")
    private String branch;

    @RequestMapping("/client")
    public String client(){
        return userName + ", " + userPwd + ", " + branch;
    }
}
