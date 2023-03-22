package com.javasm.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "url")
@Data
public class MicoServerUrl {
    private String orderurl;
    private String producturl;
    private String roleurl;
}
