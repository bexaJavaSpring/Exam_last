package com.example.exam_last.oauth2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/facebook")
public class MyfacebookController {

    @GetMapping("/login")
    public String loginPage(){
        return "facebook";
    }
}
