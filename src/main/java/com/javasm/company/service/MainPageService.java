package com.javasm.company.service;

import com.javasm.bean.returnData.ReturnData;
import com.javasm.company.bean.Vo.CompanyEmployeeInfoVo;

import javax.servlet.http.HttpServletRequest;

public interface MainPageService {
    ReturnData<CompanyEmployeeInfoVo> initEmployeeInfo(HttpServletRequest req);
}
