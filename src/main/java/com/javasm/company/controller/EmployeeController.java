package com.javasm.company.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.javasm.bean.returnData.ReturnData;
import com.javasm.company.bean.CompanyEmployeeInfo;
import com.javasm.company.bean.Vo.CompanyEmployeeInfoVo;
import com.javasm.company.mapper.CompanyEmployeeInfoMapper;
import com.javasm.company.service.EmployeeService;
import com.javasm.util.PaginationHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Resource
    private PaginationHelper paginationHelper;
    @Resource
    private CompanyEmployeeInfoMapper mapper;
    @Resource
    private EmployeeService employeeService;
    @RequestMapping("initTable")
    public Map initTable(String nowPage, String pageSize, HttpServletRequest req){
        paginationHelper.setPrePageInfo(Integer.valueOf(pageSize));
        paginationHelper.setPage(Integer.valueOf(nowPage));
        //获取公司id,得到总数
        CompanyEmployeeInfo loginUser = (CompanyEmployeeInfo)req.getSession().getAttribute("loginUser");
        Integer companyId=loginUser.getCompanyId();
        LambdaQueryWrapper<CompanyEmployeeInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CompanyEmployeeInfo::getCompanyId,companyId);
        Integer count = mapper.selectCount(queryWrapper);
        paginationHelper.setTotalInfo(count);
        ReturnData<List<CompanyEmployeeInfoVo>> returnData = employeeService.findAll(paginationHelper, companyId);
        Map map=new HashMap();
        map.put("num",count);
        map.put("returnData",returnData);
        return map;
    }
    //name:'',
    //accept:false,
    //state:false
    @RequestMapping("initTableByTj")
    public Map initTableByTj(String nowPage, String pageSize, HttpServletRequest req,String name,boolean accept,boolean state){
        paginationHelper.setPrePageInfo(Integer.valueOf(pageSize));
        paginationHelper.setPage(Integer.valueOf(nowPage));
        //获取公司id,得到总数
        CompanyEmployeeInfo loginUser = (CompanyEmployeeInfo)req.getSession().getAttribute("loginUser");
        Integer companyId=loginUser.getCompanyId();
        //选择器  多条件模糊查询
        LambdaQueryWrapper<CompanyEmployeeInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.and(
                wrapper ->
                        wrapper.like(CompanyEmployeeInfo::getEmployeeEmail, name).or().like(CompanyEmployeeInfo::getEmployeeName, name)
        );
        queryWrapper.eq(CompanyEmployeeInfo::getCompanyId,companyId);
        Integer acceptNum;
        if(accept==true){
            acceptNum=1;
            queryWrapper.eq(CompanyEmployeeInfo::getAccept,acceptNum);
        }
        Integer stateNum;
        if(state==true){
            stateNum=1;
            queryWrapper.eq(CompanyEmployeeInfo::getState,stateNum);
        }
        Integer count = mapper.selectCount(queryWrapper);
        paginationHelper.setTotalInfo(count);
        ReturnData<List<CompanyEmployeeInfo>> returnData = employeeService.findAllByTj(paginationHelper,queryWrapper);
        Map map=new HashMap();
        map.put("num",count);
        map.put("returnData",returnData);
        return map;
    }

}
