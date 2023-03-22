package com.javasm.listener;

import com.javasm.bean.entity.UserInfo;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
        UserInfo userInfo = event.getUserInfo();
        System.out.println(userInfo.getUserId());
        System.out.println(userInfo.getUserName());
        System.out.println(userInfo.getUserPwd());
    }
}
