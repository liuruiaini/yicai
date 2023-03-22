package com.javasm.listener;

import com.javasm.bean.entity.UserInfo;
import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {
    private UserInfo userInfo;

    public MyEvent(Object source, UserInfo userInfo) {
        super(source);
        this.userInfo = userInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
