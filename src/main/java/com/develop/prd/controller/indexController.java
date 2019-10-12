package com.develop.prd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

    @RequestMapping("/battalion")
    public String index() {
        return "index";
    }
}
