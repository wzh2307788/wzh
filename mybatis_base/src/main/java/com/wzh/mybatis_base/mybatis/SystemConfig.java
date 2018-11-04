package com.wzh.mybatis_base.mybatis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemConfig {

    @Bean
    public Author author(){
        return new Author("wzh");
    }

}
