package com.ddcode.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosProvider8001 {
    public static void main(String[] args) {
        SpringApplication.run(NacosProvider8001.class);
    }
}
