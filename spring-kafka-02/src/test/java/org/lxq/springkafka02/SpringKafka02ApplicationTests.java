package org.lxq.springkafka02;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.lxq.springkafka02.Prouder.EventProducer;
import org.lxq.springkafka02.bean.Student;
import org.lxq.springkafka02.bean.User;
import org.lxq.springkafka02.service.StudentService;
import org.lxq.springkafka02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringKafka02ApplicationTests {
    @Resource
    UserService userService;
    @Resource
    StudentService studentService;
    @Resource
    EventProducer eventProducer;

    @Test
    void contextLoads() {
        eventProducer.send1();
    }


    @Test
    void test(){
        User user = userService.selectById(1);
        System.out.println(user);
    }

    @Test
    void test2(){
        User user = User.builder().userId(null).userAge(25).userName("王99").userSex("男").build();
        Integer i = userService.insertUser(user);
        System.out.println(i);
    }

    @Test
    void test3(){
        Integer i = userService.deleteById(2);
        System.out.println(i);
    }

    @Test
    void test4(){
        User user = User.builder().userName("赵六").userAge(44).userId(2).userSex("男").build();
        Integer i = userService.updateById(user);
        System.out.println(i);

    }

    @Test
    void test5(){

        List<User> userList = userService.selectBySex("男");
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

    @Test
    void test6(){
        Student build = Student.builder().studentId(null)
                .studentAge(25)
                .studentName("廉旭前")
                .studentSex("男")
                .classId(3)
                .build();
        studentService.insertStudent(build);


    }



}
