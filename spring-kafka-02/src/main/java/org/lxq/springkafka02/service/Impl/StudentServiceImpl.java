package org.lxq.springkafka02.service.Impl;

import jakarta.annotation.Resource;
import org.lxq.springkafka02.bean.Student;
import org.lxq.springkafka02.mapper.StudentMapper;
import org.lxq.springkafka02.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;
    @Override
    public int insertStudent(Student student) {
        return studentMapper.insertStudent(student);
    }
}
