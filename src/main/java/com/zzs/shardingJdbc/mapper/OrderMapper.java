package com.zzs.shardingJdbc.mapper;

import com.zzs.shardingJdbc.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface OrderMapper {

    @Insert("insert into zzs_order(ordernumber,userid,productid,createTime) values(#{ordernumber},#{userid},#{productid},#{createTime})")
    @Options(useGeneratedKeys = true,keyColumn = "orderid",keyProperty = "orderid")
    void addOrder(Order order);
}
