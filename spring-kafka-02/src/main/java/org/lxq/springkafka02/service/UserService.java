package org.lxq.springkafka02.service;

import org.lxq.springkafka02.bean.User;

import java.util.List;

public interface UserService {
    User selectById(Integer userId);


    Integer insertUser(User user);

    Integer deleteById(Integer userId);

    Integer updateById(User user);

    List<User> selectBySex(String user);
}
