package org.lxq.springkafka02.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    private Integer studentId;
    private String studentName;

    private String studentSex;

    private Integer studentAge;

    private Integer classId;
}
