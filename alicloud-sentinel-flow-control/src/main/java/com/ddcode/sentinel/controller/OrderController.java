package com.ddcode.sentinel.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/sentinel")
@Slf4j
public class OrderController {

    @GetMapping("/echo")
    public String echo() {
        return "echo";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    /**
     * 测试降级
     * @return
     */
    @GetMapping("/sleep")
    public String sleep() throws InterruptedException {
        //休眠2s
        TimeUnit.SECONDS.sleep(1);
        log.info("sleep");
        return "sleep";
    }
}
