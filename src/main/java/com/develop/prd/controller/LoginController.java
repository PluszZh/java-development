package com.develop.prd.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpServletRequest request) {
        if(StringUtils.equals(username,"admin") && StringUtils.equals(password,"123456")) {
            request.getSession().setAttribute("username",username);
            return "redirect:battalion";
        }
        model.addAttribute("errMsg","用户名或者密码错误!");
        return "login";


    }
}
