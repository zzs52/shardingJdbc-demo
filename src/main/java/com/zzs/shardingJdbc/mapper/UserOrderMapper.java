package com.zzs.shardingJdbc.mapper;

import com.zzs.shardingJdbc.entity.UserOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserOrderMapper {

    @Insert("insert into zzs_user_order(userid,ordernumber,createTime,yearmonth) values(#{userid},#{ordernumber},#{createTime},#{yearmonth})")
    @Options(useGeneratedKeys = true,keyColumn = "orderid",keyProperty = "orderid")
    void addUserOrder(UserOrder userOrder);
}
