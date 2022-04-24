package com.ddcode.event.service;

import com.ddcode.event.ervent.UserRegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * 监听注册事件
 * 方式2
 */
@Service
@Slf4j
public class CouponService {

    @EventListener
    public void assCoupon(UserRegisterEvent event){
        log.info("[addCoupon][给用户({}) 发放优惠劵]", event.getUsername());
    }
}
