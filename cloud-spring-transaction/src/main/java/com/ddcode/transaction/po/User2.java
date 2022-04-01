package com.ddcode.transaction.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user2")
public class User2 {

    Integer id;
    String name;
}
