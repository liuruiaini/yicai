package com.javasm.company.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.javasm.bean.returnData.ReturnData;
import com.javasm.company.bean.CompanyEmployeeInfo;
import com.javasm.company.bean.Vo.CompanyEmployeeInfoVo;
import com.javasm.util.PaginationHelper;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface EmployeeService {
    ReturnData<List<CompanyEmployeeInfoVo>> findAll(PaginationHelper helper,Integer companyId);

    ReturnData<List<CompanyEmployeeInfo>> findAllByTj(PaginationHelper paginationHelper, LambdaQueryWrapper<CompanyEmployeeInfo> queryWrapper);

    ReturnData<Integer> addUser(CompanyEmployeeInfo addEmployee, HttpServletRequest req);
}
