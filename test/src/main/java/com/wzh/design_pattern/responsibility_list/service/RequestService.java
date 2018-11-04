package com.wzh.design_pattern.responsibility_list.service;

import com.wzh.design_pattern.responsibility_list.req.FeeRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Service
@Controller
public class RequestService {
    @RequestMapping("/helloWorld")

    public String helloWorld(Model model) {

        model.addAttribute("message", "Hello World!");

        return "helloWorld";

    }
    @RequestMapping("/feeRequest2")
    public String feeRequetHandle(FeeRequest feeRequest){
        System.out.println("ok");
        System.out.println(feeRequest.getEmployee().getName());


        return "ok";
    }

    @RequestMapping("/feeRequest")
    public String feeRequetOrigHandle(@RequestParam String requesterName, @RequestParam long feeNum){
        System.out.println("ok");
        System.out.println(requesterName);
        return "ok";
    }
}
