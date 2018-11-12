package com.wzh.design_pattern.responsibility_list;

import com.wzh.design_pattern.responsibility_list.service.RequestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//@EnableAutoConfiguration
@SpringBootApplication
@EnableWebMvc
public class Bootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext=
                SpringApplication.run(Bootstrap.class);

        RequestService requestService=configurableApplicationContext.getBean(RequestService.class);
        requestService.feeRequest("err",77d);
        System.out.println("end___________________________________");
    }
}
