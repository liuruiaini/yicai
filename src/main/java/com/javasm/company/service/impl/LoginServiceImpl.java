package com.javasm.company.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.javasm.bean.returnData.ReturnData;
import com.javasm.company.bean.CompanyEmployeeInfo;
import com.javasm.company.mapper.CompanyEmployeeInfoMapper;
import com.javasm.company.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private CompanyEmployeeInfoMapper mapper;
    @Override
    public ReturnData<Integer> login(String employeeEmail, String employeePwd, HttpServletRequest req) {
        log.info(employeeEmail);
        log.info(employeePwd);
        //1.查询返回用户密码和传输密码是否一致
        ReturnData<Integer> returnData = new ReturnData<>();
        returnData.setMessage("登陆失败!!!");
        returnData.setCode(500);
        LambdaQueryWrapper<CompanyEmployeeInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CompanyEmployeeInfo::getEmployeeEmail,employeeEmail);
        CompanyEmployeeInfo companyEmployeeInfo = mapper.selectOne(queryWrapper);
        if (companyEmployeeInfo.getEmployeePwd().equals("123456")){
            returnData.setT(1);
            returnData.setMessage("登录成功!!!");
            returnData.setCode(200);
            //2.若一致返回正确returnData；并将用户信息存入session；将accepet改为1
            //LambdaQueryWrapper<CompanyEmployeeInfo> queryWrapper2 = new LambdaQueryWrapper<>();
            companyEmployeeInfo.setAccept(1);
            int update = mapper.update(companyEmployeeInfo, queryWrapper);
            log.info("更新accepet是否成功===={}",update);
            req.getSession().setAttribute("loginUser",companyEmployeeInfo);




            return returnData;
        }
        //3.不一致，直接返回
        return returnData;




    }
}
