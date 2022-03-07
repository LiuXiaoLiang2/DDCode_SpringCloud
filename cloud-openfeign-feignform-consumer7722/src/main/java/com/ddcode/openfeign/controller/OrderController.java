package com.ddcode.openfeign.controller;

import com.ddcode.openfeign.pojo.User;
import com.ddcode.openfeign.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/openfeign/consumer/echo6")
    public String echo6(@RequestPart(value = "file") MultipartFile file, @RequestParam(value= "name", required = false) String name) {
        String echo = orderService.echo6(file, name);
        log.info("echo {} ", echo);
        return echo;
    }

    @PostMapping("/openfeign/consumer/echo9")
    public String echo9(User user) {
        String echo = orderService.echo9(user);
        log.info("echo9 {} ", echo);
        return echo;
    }
}
