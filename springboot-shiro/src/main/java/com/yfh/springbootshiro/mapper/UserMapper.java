package com.yfh.springbootshiro.mapper;

import com.yfh.springbootshiro.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//@Mapper
public interface UserMapper {

    List<User> queryUserList();

    User queryUserById(Integer id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(Integer id);

    @Select("select * from shirodb.t_user where name = #{name}")
    User queryUserByName(@Param("name") String name);
}
