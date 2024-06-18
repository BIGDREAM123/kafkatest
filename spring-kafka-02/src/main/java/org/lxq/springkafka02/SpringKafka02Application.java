package org.lxq.springkafka02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"org.lxq.springkafka02.mapper"})
public class SpringKafka02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringKafka02Application.class, args);
    }

}
