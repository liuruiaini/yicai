package com.javasm.bean.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class RoleInfo {
    private Integer roleId;
    private String roleName;
    private Integer userId;
}
