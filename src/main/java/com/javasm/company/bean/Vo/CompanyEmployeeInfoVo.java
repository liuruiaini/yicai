package com.javasm.company.bean.Vo;

import com.javasm.company.bean.CompanyEmployeeInfo;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class CompanyEmployeeInfoVo extends CompanyEmployeeInfo {
    private String companyName;
    private String menuName;
}
