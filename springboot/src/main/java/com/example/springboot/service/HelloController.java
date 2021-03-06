package com.example.springboot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @Value("${name}")
    private String name;

    @Value("${user.name}")
    private String userName;

    @Value("${bookTitle}")
    private String bookTitle;

    @RequestMapping("/")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        System.out.println("NAME= "+name);
        System.out.println("bookTitle= "+bookTitle);

        System.out.println("USERNAME= "+userName);
        //1、username 不是读取配置文件的
        map.addAttribute("name", userName);
        map.addAttribute("bookTitle", bookTitle);
        // return模板文件的名称，对应src/main/resources/templates/welcome.html
        return "welcome";
    }
}
