package com.zzs.shardingJdbc.service;

import com.zzs.shardingJdbc.entity.Order;
import com.zzs.shardingJdbc.entity.User;
import com.zzs.shardingJdbc.mapper.OrderMapper;
import com.zzs.shardingJdbc.mapper.UserMapper;
import io.shardingsphere.transaction.annotation.ShardingTransactionType;
import io.shardingsphere.transaction.api.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserOrderService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @ShardingTransactionType(TransactionType.XA)
    @Transactional(rollbackFor = Exception.class)
    public int saveUserOrder(User user, Order order) {
        userMapper.addUser(user);
        order.setUserid(user.getId());
        // int a = 1/0; // 测试回滚，统一提交的话，将这行注释掉就行
        orderMapper.addOrder(order);
        return 1;
    }
}
