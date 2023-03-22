package com.javasm.company.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javasm.bean.returnData.ReturnData;
import com.javasm.company.bean.CompanyEmployeeInfo;
import com.javasm.company.bean.Vo.CompanyEmployeeInfoVo;
import com.javasm.company.mapper.CompanyEmployeeInfoMapper;
import com.javasm.company.mapper.CompanyEmployeeInfoVoMapper;
import com.javasm.company.service.EmployeeService;
import com.javasm.util.PaginationHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
}
