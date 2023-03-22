package com.javasm.interceptor;

import com.javasm.annotation.DoInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class MyInterceptor implements HandlerInterceptor {
    private final static Logger log= LoggerFactory.getLogger(MyInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod=(HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        String methodName=method.getName();
        DoInterceptor annotation = method.getAnnotation(DoInterceptor.class);
        if(annotation!=null&&!annotation.equals("")){
            log.info("当前拦截的方法为====={},拦截了哈！！！",methodName);
            return false;
        }
        log.info("当前拦截的方法为====={},放行了哈！！！",methodName);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
