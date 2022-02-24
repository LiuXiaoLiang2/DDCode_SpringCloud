package com.ddcode.ribbon.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class RibbonConsumerController {

    private static String BASE_URL = "ribbon-nacos-quickstart-provider";

    @Resource
    private RestTemplate restTemplate;

    /**
     * 方式1
     * @return
     */
    @RequestMapping("/ribbon/myrule/consumer")
    public String orderConsumer1(){
        String forObject = restTemplate.getForObject("http://" + BASE_URL + "/ribbon/quickstart/provider", String.class);
        log.info("orderConsumer {}", forObject);
        return forObject;
    }

}
