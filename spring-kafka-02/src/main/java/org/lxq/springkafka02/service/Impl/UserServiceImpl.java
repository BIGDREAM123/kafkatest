package org.lxq.springkafka02.service.Impl;

import jakarta.annotation.Resource;
import org.lxq.springkafka02.bean.User;
import org.lxq.springkafka02.mapper.UserMapper;
import org.lxq.springkafka02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public User selectById(Integer userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public Integer insertUser(User user) {
        Integer i = userMapper.insertUser(user);
        stringRedisTemplate.opsForValue().set("user",user.toString(),1000, TimeUnit.SECONDS);
        return i;

    }

    @Override
    public Integer deleteById(Integer userId) {
        Integer i = userMapper.deleteById(userId);
        return i;

    }

    @Override
    @Transactional()
    public Integer updateById(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public List<User> selectBySex(String userSex) {
        return userMapper.selectBySex(userSex);
    }


}
