package com.javasm.company.controller;

import com.javasm.bean.returnData.ReturnData;
import com.javasm.company.service.LoginService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

//@CrossOrigin
@RestController
@RequestMapping("login")
public class LoginController {
    @Resource
    private LoginService loginService;
    @RequestMapping("login")
    public ReturnData<Integer> login(@RequestParam(value = "userName") String employeeEmail, @RequestParam(value = "userPwd") String employeePwd, HttpServletRequest req){
       return loginService.login(employeeEmail,employeePwd,req);

    }
}
