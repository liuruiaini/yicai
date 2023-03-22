package com.javasm.bean.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserAndRole extends UserInfo{
    private String roleName;
}
