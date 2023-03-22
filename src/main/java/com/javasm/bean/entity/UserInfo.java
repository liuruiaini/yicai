package com.javasm.bean.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserInfo {
    private Integer userId;
    private String userName;
    private String userPwd;
}
