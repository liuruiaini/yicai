package com.javasm.bean.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Emailuser {

  private long emailuserId;
  private String emailuserEmail;
}
