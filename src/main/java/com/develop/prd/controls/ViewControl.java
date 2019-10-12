package com.develop.prd.controls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 全站视图解析器
 */
@Controller
public class ViewControl {

    @RequestMapping("/charts")
    public String charsview(){
        return "charts.html";
    }
    @RequestMapping("/forms")
    public String formsview(){
        return "forms.html";
    }
    @RequestMapping("/index")
    public String indexview(){
        return "index.html";
    }
    @RequestMapping("/login")
    public String loginsview(){
        return "login.html";
    }
    @RequestMapping("/register")
    public String registerview(){
        return "register.html";
    }
    @RequestMapping("/tables")
    public String tableview(){
        return "tables.html";
    }

}
