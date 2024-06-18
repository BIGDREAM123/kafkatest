package org.lxq.springbootkafkabase01.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.lxq.springbootkafkabase01.bean.User;
import org.lxq.springbootkafkabase01.util.JsonUtil;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class EventConsumer {
    @KafkaListener(topics = "test" , groupId = "2")
public void listen(String message, Acknowledgment ack){
    System.out.println("message = " + message);
    ack.acknowledge();
}


    @KafkaListener(topicPartitions = {@TopicPartition(topic = "test",partitions = {"2"})},groupId = "3")
    public void listen2(@Payload String message, @Header(value = KafkaHeaders.TOPIC) String topic, @Header(value = KafkaHeaders.PARTITION) String partition,Acknowledgment ack, ConsumerRecord<String,String> consumerRecord){
        User object = JsonUtil.toObject(message, User.class);
        System.out.println(topic);
        System.out.println(partition);
        System.out.println("接收到消息： "+ object.toString());
        System.out.println(consumerRecord.toString());
        ack.acknowledge();


    }
}
