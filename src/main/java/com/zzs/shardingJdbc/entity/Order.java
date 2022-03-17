package com.zzs.shardingJdbc.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    // 主键
    private Long orderid;
    // 订单编号
    private String ordernumber;
    // 用户ID
    private Long userid;
    // 产品id
    private Long productid;
    // 创建时间
    private Date createTime;
}
