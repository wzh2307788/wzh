package com.example.springboot.service;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

@RequestMapping("/a")

public class HelloWorldController {

    @RequestMapping("/helloWorld")
    @ResponseBody
    public String helloWorld() {


        return "helloWorld";

    }

}
