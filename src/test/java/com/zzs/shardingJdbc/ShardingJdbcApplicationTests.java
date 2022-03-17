package com.zzs.shardingJdbc;

import com.zzs.shardingJdbc.entity.Order;
import com.zzs.shardingJdbc.entity.User;
import com.zzs.shardingJdbc.entity.UserOrder;
import com.zzs.shardingJdbc.mapper.OrderMapper;
import com.zzs.shardingJdbc.mapper.UserOrderMapper;
import com.zzs.shardingJdbc.service.UserOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Random;

@SpringBootTest
class ShardingJdbcApplicationTests {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    void contextLoads() throws Exception {
        Order order = new Order();
        order.setOrdernumber("133455678");
        order.setUserid(1234L);
        order.setProductid(1234L);
        order.setCreateTime(new Date());
        orderMapper.addOrder(order);
    }

    @Autowired
    private UserOrderMapper userOrderMapper;

    @Test
    void contextLoads1() {
        UserOrder userOrder = new UserOrder();
        userOrder.setUserid(1L);
        userOrder.setOrdernumber("133455678");
        userOrder.setCreateTime(new Date());
        userOrder.setYearmonth("202202");
        userOrderMapper.addUserOrder(userOrder);
    }

    @Autowired
    private UserOrderService userOrderService;

    @Test
    void contextLoads2() throws Exception {
        User user = new User();
        user.setNickname("zhangsan" + new Random().nextInt());
        user.setPassword("1234567");
        user.setSex(1);
        user.setAge(2);
        user.setBirthday(new Date());
        Order order = new Order();
        order.setOrdernumber("133455678");
        order.setProductid(1234L);
        order.setCreateTime(new Date());
        userOrderService.saveUserOrder(user, order);
    }
}
