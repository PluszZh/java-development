package com.develop.prd.controller.sys;

import com.develop.prd.core.Result;
import com.develop.prd.core.ResultGenerator;
import com.develop.prd.model.Job;
import com.develop.prd.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JobController {

    private static final String root = "sys";

    @Autowired
    private JobService jobService;

    @RequestMapping("/battalion/job")
    public String job(Model model) {
        List<Job> jobs = jobService.list();
        model.addAttribute("jobs",jobs);
        return root + "/job";
    }

    @PostMapping("/battalion/saveJob")
    public String saveJob(Job job) {
        jobService.save(job);
        return "redirect:/battalion/job";
    }

    @PostMapping("/battalion/editJob")
    @ResponseBody
    public Result editJob(@RequestParam("id") Integer id) {
        Job job = jobService.findById(id);
        return ResultGenerator.genSuccessResult(job);
    }

}
