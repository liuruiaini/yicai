package com.javasm.company.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.stereotype.Component;


import java.util.Date;
@Component
@Data
public class CompanyEmployeeInfo {
  @TableId(type = IdType.AUTO)
  private Integer employeeId;
  private Integer companyId;
  private String employeeEmail;
  private String employeePhone;
  private String employeeName;
  private String employeePwd;
  private String employeeDpt;
  private String employeePost;
  private Integer menuId;
  private String employeeJoinTime;
  private String employeeLatestTime;
  private Integer accept;
  private Integer state;



}
