package org.lxq.springkafka02.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.lxq.springkafka02.bean.User;

import java.util.List;
//@Mapper
public interface UserMapper {
    User selectById(Integer userId);


    Integer insertUser(User user);
    @Delete("delete from user where user_id =#{userId}")
    Integer deleteById(Integer userId);

    @Update("update user set user_name=#{userName},user_age=#{userAge} where user_id=#{userId}")
    Integer updateById(User user);
    @Select("select user_id,user_name,user_age,user_sex from user where user_sex =#{userSex}")
    List<User> selectBySex(String userSex);
}
