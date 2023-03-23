package com.javasm.company.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javasm.bean.returnData.ReturnData;
import com.javasm.company.bean.CompanyEmployeeInfo;
import com.javasm.company.bean.Vo.CompanyEmployeeInfoVo;
import com.javasm.company.mapper.CompanyEmployeeInfoMapper;
import com.javasm.company.mapper.CompanyEmployeeInfoVoMapper;
import com.javasm.company.service.EmployeeService;
import com.javasm.util.EmailUtil;
import com.javasm.util.PaginationHelper;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private CompanyEmployeeInfoVoMapper mapper;
    @Resource
    private CompanyEmployeeInfoMapper mapperPlus;
    @Override
    public ReturnData<List<CompanyEmployeeInfoVo>> findAll(PaginationHelper helper,Integer companyId) {
        ReturnData<List<CompanyEmployeeInfoVo>> returnData = new ReturnData<>();
        returnData.setMessage("代码错误");
        returnData.setCode(500);
        Integer index=helper.getCurrentPageStart();
        Integer size=helper.getPrePageInfo();
        List<CompanyEmployeeInfoVo> all = mapper.findAll(index, size, companyId);
        if(null!=all){
            returnData.setMessage("代码正确");
            returnData.setCode(200);
            returnData.setT(all);
            return returnData;
        }
        return returnData;


    }

    @Override
    public ReturnData<List<CompanyEmployeeInfo>> findAllByTj(PaginationHelper paginationHelper, LambdaQueryWrapper<CompanyEmployeeInfo> queryWrapper) {
        ReturnData<List<CompanyEmployeeInfo>> returnData=new ReturnData<>();
        returnData.setMessage("代码错误");
        returnData.setCode(500);
        Page<CompanyEmployeeInfo> page = new Page<>(paginationHelper.getPage(),paginationHelper.getPrePageInfo());
        Page<CompanyEmployeeInfo> result = mapperPlus.selectPage(page, queryWrapper);
        //ipage转list
        if(null!=result){
            returnData.setMessage("代码正确");
            returnData.setCode(200);
            List<CompanyEmployeeInfo> list=result.getRecords();
            returnData.setT(list);
            return returnData;
        }
        return returnData;

    }

    @Override
    public ReturnData<Integer> addUser (CompanyEmployeeInfo addEmployee, HttpServletRequest req) {
        ReturnData<Integer> returnData=new ReturnData<>();
        returnData.setMessage("代码错误");
        returnData.setCode(500);


        CompanyEmployeeInfo loginUser= (CompanyEmployeeInfo) req.getSession().getAttribute("loginUser");
        //1.发送邮件邀请注册,若异常，会被全局异常捕获
        try {
            EmailUtil.sendEmail(addEmployee.getEmployeeEmail(),loginUser.getEmployeeName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //2.插入数据
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        addEmployee.setEmployeeJoinTime(format);
        Integer companyId=loginUser.getCompanyId();
        addEmployee.setCompanyId(companyId);
        int insert = mapperPlus.insert(addEmployee);
        if(insert>0){
            returnData.setMessage("代码正确");
            returnData.setCode(200);
            returnData.setT(insert);
            return returnData;
        }
        return returnData;


    }
}
