package com.ddcode.event.controller;

import com.ddcode.event.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/event")
public class EventController {

    @Resource
    private UserService userService;

    @GetMapping("/register")
    public String register(String username) {
        userService.register(username);
        return "success";
    }
}
