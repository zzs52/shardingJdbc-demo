package com.zzs.shardingJdbc.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserOrder {
    // 主键
    private Long orderid;
    // 用户ID
    private Long userid;
    // 订单编号
    private String ordernumber;
    // 创建时间
    private Date createTime;
    // 年月
    private String yearmonth;
}
