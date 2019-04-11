package cn.silen_dev.sarcoidosis.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {
    @GetMapping
    @ResponseBody
    public String index(){
        return "hello";
    }
    @RequestMapping("/password")
    @ResponseBody
    public String password(String password){
        return new BCryptPasswordEncoder().encode(password);
    }
}
