package com.javasm.company.service;

import com.javasm.bean.returnData.ReturnData;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {
    ReturnData<Integer> login(String employeeEmail, String employeePwd, HttpServletRequest req);
}
