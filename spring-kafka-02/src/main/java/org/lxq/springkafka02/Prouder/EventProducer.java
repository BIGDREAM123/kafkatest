package org.lxq.springkafka02.Prouder;

import jakarta.annotation.Resource;
import org.lxq.springkafka02.Util.JsonUtil;
import org.lxq.springkafka02.bean.User;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventProducer {
    @Resource
    private KafkaTemplate<String,String> kafkaTemplate;

    public void send1(){
//        User lxq = User.builder().age(1).name("lxq").build();
//        String json = JsonUtil.toJson(lxq);
//
//
//        kafkaTemplate.send("test",json);
        User user = User.builder().userAge(27).userName("赵六").userSex("男").build();
        String json = JsonUtil.toJson(user);
        kafkaTemplate.send("test",json);

    }

}
