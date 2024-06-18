package org.lxq.springbootkafkabase01.producer;

import jakarta.annotation.Resource;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.apache.kafka.common.header.internals.RecordHeaders;
import org.lxq.springbootkafkabase01.bean.User;
import org.lxq.springbootkafkabase01.util.JsonUtil;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
public class EventProducer {
    @Resource
    private  KafkaTemplate<String,String> kafkaTemplate;
    @Resource
    private KafkaTemplate<String,Object> kfTemplate2;


    public void send(){
        kafkaTemplate.send("test5","hello, lxq");
    }
    public void send2(){
        Message<String> build = MessageBuilder.withPayload("111")
                .setHeader(KafkaHeaders.TOPIC, "test")
                .setHeader(KafkaHeaders.PARTITION, "1")
                .build();
        kafkaTemplate.send("test2","hello, lxq");
    }

    public void send3(){
        Headers header = new RecordHeaders();
        header.add(new RecordHeader("name", "lxq".getBytes()));


        ProducerRecord<String, String> producerRecord = new ProducerRecord<>("test",1,"aa", "hello, lxq"
        ,header);
        kafkaTemplate.send(producerRecord);
    }

    public void send4(){
        CompletableFuture<SendResult<String, String>> send = kafkaTemplate.send("test", 1, "aa", "hello, lxq");

        try {
            SendResult<String, String> stringStringSendResult = send.get();
            if(stringStringSendResult.getRecordMetadata() != null){
                System.out.println("接受到消息:" + stringStringSendResult.getRecordMetadata().toString());
            }
            System.out.println(stringStringSendResult.getProducerRecord().toString());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void send5(){
        CompletableFuture<SendResult<String, String>> send = kafkaTemplate.send("test", null, "aa", "nihao, lxq");

        send.thenAccept((sendResult)->{
            if(sendResult.getRecordMetadata() !=null){
                System.out.println("接受到消息:" + sendResult.getRecordMetadata().toString());
            }
            System.out.println("a: "+sendResult.getProducerRecord().toString());

        }).exceptionally((e)->{
            throw new RuntimeException(e);
        });
    }

    public void send6(){
        User lxq = User.builder().name("lxq").age(18).build();
        String json = JsonUtil.toJson(lxq);
        CompletableFuture<SendResult<String, Object>> send = kfTemplate2.send("test", 2, "aa", json);
        send.thenAccept((sendResult)->{
            if(sendResult.getRecordMetadata() !=null){
                System.out.println("接受到消息:" + sendResult.getRecordMetadata().toString());
            }
            System.out.println("a: "+sendResult.getProducerRecord().toString());

            }).exceptionally((e)->{
            throw new RuntimeException(e);
        });



    }

    public void send7(){
        User lxq = User.builder().name("lxq").age(18).build();
        CompletableFuture<SendResult<String, Object>> send = kfTemplate2.send("test", lxq);
        send.thenAccept((sendResult)->{
            if(sendResult.getRecordMetadata() !=null){
                System.out.println("接受到消息:" + sendResult.getRecordMetadata().toString());
            }
            System.out.println("a: "+sendResult.getProducerRecord().toString());

        }).exceptionally((e)->{
            throw new RuntimeException(e);
        });



    }

}
