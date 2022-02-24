package com.ddcode.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class RibbonProviderController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/ribbon/quickstart/provider")
    public String echo() {
        log.info("ribbon quickstart provider , server port: {}", serverPort);
        return "ribbon quickstart provider , server port: " + serverPort;
    }
}
