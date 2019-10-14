package com.develop.prd.vo;

import com.develop.prd.model.Menu;
import com.develop.prd.model.MenuCenter;
import lombok.Data;

import java.util.List;

@Data
public class MenuVo {
    private Menu menu;
    private List<MenuCenter> menuCenter;
}
