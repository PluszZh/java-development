package com.develop.prd.controls;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 活动管理
 */
@Controller
public class ActivityControl {
    @RequestMapping("/activity")
    public String avtivityviews(){
        return "activity/index";

    }
}
