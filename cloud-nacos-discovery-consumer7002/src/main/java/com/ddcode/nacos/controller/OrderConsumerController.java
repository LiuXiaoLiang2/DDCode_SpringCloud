package com.ddcode.nacos.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class OrderConsumerController {

    private static String BASE_URL = "nacos-provider";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/nacos/consumer2")
    public String orderConsumer(){
        String forObject = restTemplate.getForObject("http://" + BASE_URL + "/nacos/provider", String.class);
        log.info("orderConsumer {}", forObject);
        return forObject;
    }

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/nacos/consumer3")
    public String orderConsumer3(){
        // <1> 获得服务 `demo-provider` 的一个实例
        ServiceInstance instance;
        // 获取服务 `demo-provider` 对应的实例列表
        List<ServiceInstance> instances = discoveryClient.getInstances(BASE_URL);
        log.info("instances {}", instances);

        // 选择第一个节点
        instance = instances.size() > 0 ? instances.get(0) : null;
        // <2> 发起调用
        if (instance == null) {
            throw new IllegalStateException("获取不到实例");
        }
        String targetUrl = instance.getUri() + "/nacos/provider";
        String response = restTemplate.getForObject(targetUrl, String.class);
        return response;
    }


    @RequestMapping("/nacos/consumer4")
    public String orderConsumer4(){
        // <1> 获得服务 `demo-provider` 的一个实例
        ServiceInstance instance;
        //负载均衡选择节点
        instance = loadBalancerClient.choose(BASE_URL);
        // <2> 发起调用
        if (instance == null) {
            throw new IllegalStateException("获取不到实例");
        }
        String targetUrl = instance.getUri() + "/nacos/provider";
        String response = restTemplate.getForObject(targetUrl, String.class);
        return response;
    }
}
