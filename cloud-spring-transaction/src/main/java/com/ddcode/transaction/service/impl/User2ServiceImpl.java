package com.ddcode.transaction.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddcode.transaction.mapper.User2Mapper;
import com.ddcode.transaction.po.User2;
import com.ddcode.transaction.service.User2Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class User2ServiceImpl extends ServiceImpl<User2Mapper, User2> implements User2Service {

    @Resource
    private User2Mapper user2Mapper;

    /**
     * 加事务 + 没有抛异常
     * @param user2
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer addRequired(User2 user2) {
        int insert = user2Mapper.insert(user2);
        return insert;
    }

    /**
     * 加事务 + 抛异常
     * @param user2
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer addRequiredException(User2 user2) {
        int insert = user2Mapper.insert(user2);
        int i = 1 / 0;
        return insert;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequiresNew(User2 user){
        user2Mapper.insert(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequiresNewException(User2 user){
        user2Mapper.insert(user);
        throw new RuntimeException();
    }
}
