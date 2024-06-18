package org.lxq.springbootkafkabase01;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.lxq.springbootkafkabase01.producer.EventProducer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class SpringbootKafkaApplication {
    @Resource
    private StringRedisTemplate stringRedisTemplate;


    @Resource
    private  EventProducer eventProducer;

    @Test
    void test01() {
//        eventProducer.send();
        eventProducer.send6();
//        stringRedisTemplate.opsForValue().set("name","lxq",1000L, TimeUnit.SECONDS);

    }

}
