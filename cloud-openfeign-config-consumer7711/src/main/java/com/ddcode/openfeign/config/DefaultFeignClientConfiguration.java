package com.ddcode.openfeign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DefaultFeignClientConfiguration {
    @Bean
    public Logger.Level defaultFeignClientLoggerLevel() {
        return Logger.Level.FULL;
    }
}
