package cn.silen_dev.sarcoidosis.controller;

import cn.silen_dev.sarcoidosis.model.FailureResult;
import cn.silen_dev.sarcoidosis.model.RequestResult;
import cn.silen_dev.sarcoidosis.model.SuccessResult;
import cn.silen_dev.sarcoidosis.model.User;
import cn.silen_dev.sarcoidosis.service.MyUserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;


@Controller
public class LoginController {
    @Resource
    private MyUserDetailsService myUserDetailsService;
    @PostMapping("/user/login")
    public String authenticationLogin() throws IOException {
        return "login";
    }

    @PostMapping("/user/register")
    @ResponseBody
    public RequestResult register(@RequestBody User user){
        System.out.println(user);
        User temp=myUserDetailsService.findUser(user.getUsername());
        if (null==temp){
            myUserDetailsService.register(user.getUsername(),user.getPassword(),user.getNickname());
            return new SuccessResult("注册成功，请登录！");
        }else {
            return new FailureResult("账号已存在！");
        }

    }

}
