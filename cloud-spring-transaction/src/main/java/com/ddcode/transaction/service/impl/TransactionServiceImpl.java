package com.ddcode.transaction.service.impl;

import com.ddcode.transaction.po.User1;
import com.ddcode.transaction.po.User2;
import com.ddcode.transaction.service.TransactionService;
import com.ddcode.transaction.service.User1Service;
import com.ddcode.transaction.service.User2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    @Resource
    private User1Service user1Service;
    @Resource
    private User2Service user2Service;

    @Override
    public void insert() {
        User1 user1=new User1();
        user1.setName("张三");
        Integer integer1 = user1Service.addRequired(user1);
        log.info("user1 {} 保存结果 {}", user1, integer1);

        User2 user2=new User2();
        user2.setName("李四");
        Integer integer2 = user2Service.addRequired(user2);
        log.info("user1 {} 保存结果 {}", user1, integer1);
    }

    /**
     * 外层
     */
    @Override
    public void notransaction_exception_required_required() {
        User1 user1=new User1();
        user1.setName("张三");
        Integer integer1 = user1Service.addRequired(user1);
        log.info("user1 {} 保存结果 {}", user1, integer1);

        User2 user2=new User2();
        user2.setName("李四");
        Integer integer2 = user2Service.addRequired(user2);
        log.info("user1 {} 保存结果 {}", user1, integer1);

        int i = 1 / 0;
    }

    @Override
    public void notransaction_required_required_exception() {
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2=new User2();
        user2.setName("李四");
        user2Service.addRequiredException(user2);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_exception_required_required(){
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2=new User2();
        user2.setName("李四");
        user2Service.addRequired(user2);

        throw new RuntimeException();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_required_required_exception() {
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2=new User2();
        user2.setName("李四");
        user2Service.addRequiredException(user2);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void transaction_required_required_exception_try() {
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.addRequired(user1);

        User2 user2=new User2();
        user2.setName("李四");
        try {
            user2Service.addRequiredException(user2);
        } catch (Exception e) {
            log.error("方法回滚" , e);
        }
    }

    @Override
    public void notransaction_exception_requiresNew_requiresNew() {
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.addRequiresNew(user1);

        User2 user2=new User2();
        user2.setName("李四");
        user2Service.addRequiresNew(user2);
        throw new RuntimeException();
    }

    @Override
    public void notransaction_requiresNew_requiresNew_exception() {
        User1 user1=new User1();
        user1.setName("张三");
        user1Service.addRequiresNew(user1);

        User2 user2=new User2();
        user2.setName("李四");
        user2Service.addRequiresNewException(user2);
    }
}
