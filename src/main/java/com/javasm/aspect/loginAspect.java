//package com.javasm.aspect;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.Signature;
//import org.aspectj.lang.annotation.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Aspect
//@Component
//public class loginAspect {
//    Logger log= LoggerFactory.getLogger(loginAspect.class);
//    @Pointcut("execution(* com.javasm.service..*.*(..))")
//    public void pointCut(){ }
//    @Before("pointCut()")
//    public void doBefore(JoinPoint joinPoint){
//        Object[] args = joinPoint.getArgs();
//        for (Object arg : args) {
//            log.info("参数======={}",arg.toString());
//        }
//        Object target = joinPoint.getTarget();
//        log.info("target======={}",target);
//        Signature signature = joinPoint.getSignature();
//        String declaringTypeName = signature.getDeclaringTypeName();
//        String name = signature.getName();
//        log.info("即将执行方法为: {}，属于{}包", name, declaringTypeName);
//        // 也可以用来记录一些信息，比如获取请求的url和ip
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        // 获取请求url
//        String url = request.getRequestURL().toString();
//        // 获取请求ip
//        String ip = request.getRemoteAddr();
//        log.info("用户请求的url为：{}，ip地址为：{}", url, ip);
//
//
//
//
//
//    }
//    @AfterReturning(returning = "ret",value ="pointCut()" )
//    public void doAfterReturning(JoinPoint joinPoint,Object ret){
////        log.info("{}",ret);
////        LoginUser loginUser=(LoginUser)ret;
////        log.info("当前用户是===>{}",loginUser.getName());
////        log.info("登录时间为===>{}",loginUser.getDate());
//    }
//    @AfterThrowing(pointcut = "pointCut()",throwing = "ex")
//    public void doAfterThrowing(JoinPoint joinPoint,Throwable ex){
//        log.error("========AOP捕获异常了");
//    }
//
//
//}
//
