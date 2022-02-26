package com.ddcode.openfeign.service;

import com.ddcode.openfeign.config.MyProviderFeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "openfeign-quickstart-provider", configuration = MyProviderFeignClientConfiguration.class)
public interface OrderService {

    @GetMapping("/openfeign/provider")
    public String echo(@RequestParam("name") String name);
}
