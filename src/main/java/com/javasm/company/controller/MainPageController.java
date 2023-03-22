package com.javasm.company.controller;

import com.javasm.bean.returnData.ReturnData;
import com.javasm.company.bean.Vo.CompanyEmployeeInfoVo;
import com.javasm.company.service.impl.MainPageServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("mainPage")
public class MainPageController {
    @Resource
    private MainPageServiceImpl service;
    @RequestMapping("initEmployeeInfo")
    public ReturnData<CompanyEmployeeInfoVo> initEmployeeInfo(HttpServletRequest req){
        return service.initEmployeeInfo(req);

    }
}
