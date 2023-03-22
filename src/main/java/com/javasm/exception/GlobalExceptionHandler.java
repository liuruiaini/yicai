package com.javasm.exception;

import com.javasm.bean.returnData.JosnResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {//全局异常处理类，拦截所有异常
    private final static Logger log= LoggerFactory.getLogger(GlobalExceptionHandler.class);
    //处理参数异常
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public JosnResult handleMissingServletRequestParameterException(MissingServletRequestParameterException ex){

        log.error("缺少必要请求参数,{}",ex.getMessage());
        return new JosnResult(400,"缺少请求参数兄弟!!!");
    }
    @ExceptionHandler(NullPointerException.class)
    public JosnResult handNullPointerException(NullPointerException ex){
        log.error("空指针异常,{}",ex.getMessage());
        return new JosnResult(401,"空指针了兄弟");
    }
    @ExceptionHandler(MyRuntimeException.class)
    public JosnResult handleMyRuntimeException(MyRuntimeException ex){
        log.error("异常,{}",ex.getMessage());
        return new JosnResult(ex.getBusinessEnum().getCode(),ex.getBusinessEnum().getMessage());
    }
    @ExceptionHandler(Exception.class)
    public JosnResult handleException(Exception ex){
        log.error("异常,{}",ex.getMessage());
        return new JosnResult(402,"异常了兄弟！！！！");
    }

}
