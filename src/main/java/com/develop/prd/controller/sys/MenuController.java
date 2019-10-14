package com.develop.prd.controller.sys;

import com.develop.prd.core.Result;
import com.develop.prd.core.ResultGenerator;
import com.develop.prd.model.Menu;
import com.develop.prd.service.MenuService;
import com.develop.prd.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MenuController {

    @Autowired
    private MenuService menuService;

    private final String root = "sys";

    @GetMapping("/battalion/menu")
    public String menu(Model model,@RequestParam(value = "menuName",required = false) String menuName) {
        List<Menu> menuList = menuService.list(menuName);
        model.addAttribute("menuList",menuList);
        model.addAttribute("menuName",menuName);
        return root + "/menu";
    }
    @GetMapping("/battalion/findMenu")
    @ResponseBody
    public Result findMenu(@RequestParam(value = "id") String id) {
        Menu menu = menuService.findById(id);
        return ResultGenerator.genSuccessResult(menu);
    }

    @GetMapping("/battalion/editMenu")
    @ResponseBody
    public Result editMenu(@RequestParam(value = "id") String id) {
        MenuVo menuVo = menuService.editMenu(id);

        return ResultGenerator.genSuccessResult(menuVo);
    }

    @PostMapping("/battalion/saveMenu")
    @ResponseBody
    public Result save(Menu menu) {
        Menu dbMenu = menuService.findById(menu.getMenuId());
        menu.setCreateTime(dbMenu.getCreateTime());
        menu.setMenuCreator(dbMenu.getMenuCreator());
        menuService.save(menu);
        return ResultGenerator.genSuccessResult();
    }


}

