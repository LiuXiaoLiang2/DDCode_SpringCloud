package com.ddcode.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GitClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(GitClientApplication.class, args);
    }
}
