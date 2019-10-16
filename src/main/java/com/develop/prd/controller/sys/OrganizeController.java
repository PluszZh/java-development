package com.develop.prd.controller.sys;

import com.develop.prd.model.Organize;
import com.develop.prd.service.OrganizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class OrganizeController {

    @Autowired
    private OrganizeService organizeService;

    private static final String root = "sys";

    @RequestMapping(value = "/battalion/saveOrganize",method = RequestMethod.POST)
    //@ResponseBody
    public String saveOrganize(Organize organize) {
        organizeService.save(organize);
        return "redirect:/battalion/organize";
    }

    @RequestMapping("/battalion/organize")
    public String organize(Model model) {
        List<Organize> organizes = organizeService.list();
        model.addAttribute("organizes",organizes);
        return root + "/organize";
    }
}
