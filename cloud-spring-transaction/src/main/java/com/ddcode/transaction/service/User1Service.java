package com.ddcode.transaction.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ddcode.transaction.po.User1;

public interface User1Service extends IService<User1> {

    public Integer addRequired(User1 user1);
}
