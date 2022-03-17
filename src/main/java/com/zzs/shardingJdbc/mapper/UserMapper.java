package com.zzs.shardingJdbc.mapper;

import com.zzs.shardingJdbc.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @Insert("insert into zzs_user(nickname,password,age,sex,birthday) values(#{nickname},#{password},#{age},#{sex},#{birthday})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    void addUser(User user);

    @Select("select * from zzs_user")
    List<User> findUsers();
}
