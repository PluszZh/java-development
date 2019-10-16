package com.develop.prd.controller.sys;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    private static final String root = "sys";

    @GetMapping("/battalion/account")
    public String account() {
        return root + "/account";
    }

}
