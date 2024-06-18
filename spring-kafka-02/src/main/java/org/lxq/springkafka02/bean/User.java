package org.lxq.springkafka02.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    private Integer userId;
    private String userName;
    private Integer userAge;
    private String userSex;
}
