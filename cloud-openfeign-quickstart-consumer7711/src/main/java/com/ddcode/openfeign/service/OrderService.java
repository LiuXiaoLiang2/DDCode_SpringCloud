package com.ddcode.openfeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "openfeign-quickstart-provider")
public interface OrderService {

    @GetMapping("/openfeign/provider")
    public String echo(@RequestParam("name") String name);
}
