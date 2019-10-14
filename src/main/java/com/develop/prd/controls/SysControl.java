package com.develop.prd.controls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统中心Control层
 */
@Controller
@RequestMapping("/sys")
public class SysControl {
    //菜单管理页面
    @GetMapping("/meun")
    public String meanviews(){
        return "sys/meun";
    }
    //账号管理页面
    @GetMapping("/account")
    public String accountviews(){
        return "sys/account";
    }
    //组织结构页面
    @GetMapping("/organize")
    public String organizeviews(){
        return "sys/organize";
    }
    //职务管理页面
    @GetMapping("/job")
    public String jobviews(){
        return "sys/job";
    }
    //角色管理页面
    @GetMapping("/role")
    public String roleviews(){
        return "sys/role";
    }
}
