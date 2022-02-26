package com.ddcode.openfeign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MyProviderFeignClientConfiguration {
    @Bean
    @Primary // 主 Bean
    public Logger.Level feignClientLoggerLevel() {
        return Logger.Level.FULL;
    }
}
