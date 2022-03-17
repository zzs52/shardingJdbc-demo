package com.zzs.shardingJdbc.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    // 主键
    private Long id;
    // 昵称
    private String nickname;
    // 密码
    private String password;
    // 年龄
    private Integer age;
    // 性别
    private Integer sex;
    // 生日
    private Date birthday;
}
