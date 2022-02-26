package com.ddcode.openfeign.controller;

import com.ddcode.openfeign.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ConsumerController {

    @Resource
    private OrderService orderService;

    @GetMapping("/openfeign/consumer")
    public String echo(String name) {
        String echo = orderService.echo(name);
        log.info("echo {} ", echo);
        return echo;
    }
}
