package com.ddcode.nacos.controller;

import com.alibaba.fastjson.JSONObject;
import com.ddcode.nacos.config.OrderProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class NacosOrderController {

    @Resource
    private OrderProperties orderProperties;

    @Value(value = "${order.pay-timeout-seconds}") // @NacosValue(value = "${order.pay-timeout-seconds}")
    private Integer payTimeoutSeconds;
    @Value(value = "${order.create-frequency-seconds}") // @NacosValue(value = "${order.create-frequency-seconds}")
    private Integer createFrequencySeconds;

    /**
     * 测试 @ConfigurationProperties 注解的配置属性类
     */
    @GetMapping("/test01")
    public OrderProperties test01() {
        return orderProperties;
    }

    /**
     * 测试 @Value 注解的属性
     */
    @GetMapping("/test02")
    public Map<String, Object> test02() {
        return new JSONObject().fluentPut("payTimeoutSeconds", payTimeoutSeconds)
                .fluentPut("createFrequencySeconds", createFrequencySeconds);
    }

}
