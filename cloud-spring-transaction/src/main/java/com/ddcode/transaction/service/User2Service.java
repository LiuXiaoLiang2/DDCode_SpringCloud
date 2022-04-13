package com.ddcode.transaction.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ddcode.transaction.po.User1;
import com.ddcode.transaction.po.User2;

public interface User2Service extends IService<User2> {

    public Integer addRequired(User2 user2);

    public Integer addRequiredException(User2 user2);

    public void addRequiresNew(User2 user);

    public void addRequiresNewException(User2 user);
}
