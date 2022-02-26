package com.ddcode.openfeign;

import com.ddcode.openfeign.config.DefaultFeignClientConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
//@EnableFeignClients(defaultConfiguration = DefaultFeignClientConfiguration.class)
@EnableFeignClients
public class OpenFeignConfigConsumer7711 {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignConfigConsumer7711.class);
    }
}
