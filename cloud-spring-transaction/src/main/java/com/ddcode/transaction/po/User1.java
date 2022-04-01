package com.ddcode.transaction.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user1")
public class User1 {

    Integer id;
    String name;
}
