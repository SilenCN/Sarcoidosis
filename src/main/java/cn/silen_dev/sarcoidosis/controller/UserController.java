package cn.silen_dev.sarcoidosis.controller;

import cn.silen_dev.sarcoidosis.model.FailureResult;
import cn.silen_dev.sarcoidosis.model.RequestResult;
import cn.silen_dev.sarcoidosis.model.SuccessResult;
import cn.silen_dev.sarcoidosis.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/user")
public class UserController {
    @RequestMapping("/getUsername")
    @ResponseBody
    public RequestResult getUsername(){
        User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user==null){
            return new FailureResult("当前未登录！");
        }else{
            return new SuccessResult(user.getNickname());
        }
    }
}
