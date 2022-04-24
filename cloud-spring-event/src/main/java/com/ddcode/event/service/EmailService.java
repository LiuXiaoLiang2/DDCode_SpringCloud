package com.ddcode.event.service;

import com.ddcode.event.ervent.UserRegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 监听注册事件
 * 方式1
 */
@Service
@Slf4j
public class EmailService implements ApplicationListener<UserRegisterEvent> {

    @Override
    @Async
    public void onApplicationEvent(UserRegisterEvent event) {
        log.info("[onApplicationEvent][给用户({}) 发送邮件]", event.getUsername());
    }
}
