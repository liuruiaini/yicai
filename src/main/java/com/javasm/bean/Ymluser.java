package com.javasm.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "ymluser")
@Component
@Data
public class Ymluser {
    private String name;
    private Integer age;
}
