package com.ddcode.transaction.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ddcode.transaction.mapper.User1Mapper;
import com.ddcode.transaction.po.User1;
import com.ddcode.transaction.service.User1Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class User1ServiceImpl extends ServiceImpl<User1Mapper, User1> implements User1Service{

    @Resource
    private User1Mapper user1Mapper;

    /**
     * 加事务 + 没有抛异常
     * @param user1
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer addRequired(User1 user1) {
        int insert = user1Mapper.insert(user1);
        return insert;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void addRequiresNew(User1 user){
        user1Mapper.insert(user);
    }
}
