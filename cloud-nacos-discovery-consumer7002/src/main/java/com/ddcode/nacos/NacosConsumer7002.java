package com.ddcode.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumer7002 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumer7002.class);
    }
}