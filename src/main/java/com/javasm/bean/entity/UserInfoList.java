package com.javasm.bean.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class UserInfoList {
    private List<UserInfo> list;
}
