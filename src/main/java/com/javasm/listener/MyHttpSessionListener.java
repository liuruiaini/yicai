package com.javasm.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Component
public class MyHttpSessionListener implements HttpSessionListener {
    private final static Logger log= LoggerFactory.getLogger(MyHttpSessionListener.class);
    public Integer count=0;
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.info("新用户上线了！！！");
        count++;
        se.getSession().getServletContext().setAttribute("count",count);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
       log.info("用户下线了==========");
       count--;
        se.getSession().getServletContext().setAttribute("count",count);
    }
}
