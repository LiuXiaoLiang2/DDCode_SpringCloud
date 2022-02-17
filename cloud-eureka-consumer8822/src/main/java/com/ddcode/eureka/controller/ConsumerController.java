package com.ddcode.eureka.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
//
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;

    private String serviceId = "cloud-eureka-provider8811";


    @GetMapping("/eureka/consumer/getOrder1/{id}")
    public String getOrder(@PathVariable("id") Long id){
        List<ServiceInstance> instances = discoveryClient.getInstances(serviceId);
        if(instances != null){
            //默认获取第一个
            ServiceInstance serviceInstance = instances.get(0);
            log.info("获取服务信息 {}", JSON.toJSONString(serviceInstance));
            String targetUrl = serviceInstance.getUri() + "/eureka/provider/getOrder/" + id;
            String response = restTemplate.getForObject(targetUrl, String.class);
            return response;
        }
        return null;
    }

}
