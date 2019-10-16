package com.develop.prd.controller.sys;

import com.develop.prd.core.Result;
import com.develop.prd.core.ResultGenerator;
import com.develop.prd.model.Role;
import com.develop.prd.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RoleController {

    private static final String root = "sys";

    @Autowired
    private RoleService roleService;

    @RequestMapping("/battalion/role")
    public String role(Model model) {
        List<Role> roles = roleService.list();
        model.addAttribute("roles",roles);
        return root + "/role";
    }

    @RequestMapping(value = "/battalion/addRole",method = RequestMethod.POST)
    public String addRole(Role role) {
        roleService.addRole(role);
        return "redirect:/battalion/role";
    }

    @RequestMapping(value = "/battalion/editRole",method = RequestMethod.POST)
    @ResponseBody
    public Result edit(@RequestParam("id") String roleId) {
        Role role = roleService.findById(roleId);
        return ResultGenerator.genSuccessResult(role);
    }

    @RequestMapping(value = "/battalion/saveRole",method = RequestMethod.POST)
    @ResponseBody
    public Result saveRole(Role role) {
        roleService.save(role);
        return ResultGenerator.genSuccessResult();
    }

}
