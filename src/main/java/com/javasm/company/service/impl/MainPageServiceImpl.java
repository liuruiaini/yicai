package com.javasm.company.service.impl;

import com.javasm.bean.returnData.ReturnData;
import com.javasm.company.bean.CompanyEmployeeInfo;
import com.javasm.company.bean.Vo.CompanyEmployeeInfoVo;
import com.javasm.company.mapper.CompanyEmployeeInfoVoMapper;
import com.javasm.company.service.MainPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Service
public class MainPageServiceImpl implements MainPageService {
    @Resource
    private CompanyEmployeeInfoVoMapper mapper;
    @Override
    public ReturnData<CompanyEmployeeInfoVo> initEmployeeInfo(HttpServletRequest req) {
        ReturnData<CompanyEmployeeInfoVo> returnData = new ReturnData<>();
        returnData.setMessage("代码错误");
        returnData.setCode(500);
        //从session获取当前用户id
        CompanyEmployeeInfo loginUser = (CompanyEmployeeInfo)req.getSession().getAttribute("loginUser");
        Integer id = loginUser.getEmployeeId();
        //通过id获取当前vo
        CompanyEmployeeInfoVo vo = mapper.findById(id);
        if(vo!=null){
            returnData.setMessage("代码正确");
            returnData.setCode(200);
            returnData.setT(vo);
            return returnData;
        }

        return returnData;
    }
}
