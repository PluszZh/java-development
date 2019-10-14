package com.develop.prd.controls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 客户中心Control层
 */
@Controller
@RequestMapping("/customer")
public class CusControl {

    @GetMapping("/list")
    public String listView(){
        return "customer/list";
    }
    @GetMapping("/cooperate")
    public String cooperateView(){
        return "customer/cooperate";
    }
    @GetMapping("/relation")
    public String relationView(){
        return "customer/relation.html";
    }
}
