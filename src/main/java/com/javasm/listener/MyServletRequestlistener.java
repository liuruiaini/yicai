package com.javasm.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

@Component
public class MyServletRequestlistener implements ServletRequestListener {
    private final static Logger log= LoggerFactory.getLogger(MyServletRequestlistener.class);
    @Override
    public void requestDestroyed(ServletRequestEvent event) {
        HttpServletRequest servletRequest =(HttpServletRequest) event.getServletRequest();
        StringBuffer requestURL = servletRequest.getRequestURL();
        log.info("{}===该请求已近结束",requestURL);

    }

    @Override
    public void requestInitialized(ServletRequestEvent event) {
        HttpServletRequest servletRequest =(HttpServletRequest) event.getServletRequest();
        StringBuffer requestURL = servletRequest.getRequestURL();
        log.info("请求路劲为======={}",requestURL);
        servletRequest.setAttribute("name","刘瑞");


    }
}
