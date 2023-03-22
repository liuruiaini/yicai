package com.javasm.configuration;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
@MapperScan("com.javasm.company.mapper")  //设置mapper接口的扫描
public class MybatisPlusPage {

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new  PaginationInterceptor();
    }

}

