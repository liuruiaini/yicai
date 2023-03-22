package com.javasm.company.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class CompanyBaseInfo {

  private Integer companyId;
  private String companyName;



}
