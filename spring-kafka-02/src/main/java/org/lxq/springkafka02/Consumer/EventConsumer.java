package org.lxq.springkafka02.Consumer;

import jakarta.annotation.Resource;
import org.lxq.springkafka02.Util.JsonUtil;
import org.lxq.springkafka02.bean.User;
import org.lxq.springkafka02.service.Impl.UserServiceImpl;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class EventConsumer {
    @Resource
    private UserServiceImpl userService;

    @KafkaListener(topics = "test",groupId = "test-consumer-2",concurrency = "1")
    public void listen(@Payload String message
                        , @Header(value = KafkaHeaders.RECEIVED_TOPIC) String topic
                       ,@Header(value = KafkaHeaders.RECEIVED_PARTITION) String partition
    )
{
        System.out.println("message = " + message);
    System.out.println("topic: "+ topic);
    System.out.println("partition: "+ partition);
    User object = JsonUtil.toObject(message, User.class);
    System.out.println(object);
    userService.insertUser(object);
    System.out.println("插入成功");
}
}
