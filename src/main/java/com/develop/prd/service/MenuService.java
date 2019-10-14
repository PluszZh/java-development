package com.develop.prd.service;

import com.develop.prd.handles.ServiceException;
import com.develop.prd.model.Menu;
import com.develop.prd.model.MenuCenter;
import com.develop.prd.responsity.MenuCenterResponsity;
import com.develop.prd.responsity.MenuResposity;
import com.develop.prd.vo.MenuVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuResposity menuResposity;

    @Autowired
    private MenuCenterResponsity menuCenterResponsity;

    public List<Menu> list(String menuName) {
        List<Menu> menuList;
        if(StringUtils.isBlank(menuName)) {
            menuList = menuResposity.findAll();
        }else {
            menuList = menuResposity.findByMenuNameLike("%" + menuName + "%");
        }


        return menuList;
    }

    public Menu findById(String id) {
        Optional<Menu> menu = menuResposity.findById(id);
        if(menu.isPresent()) {
            return menu.get();
        }else {
            throw new ServiceException("id出错");
        }
    }

    public MenuVo editMenu(String id) {
        MenuVo menuVo = new MenuVo();
        Menu menu = findById(id);
        List<MenuCenter> centers = menuCenterResponsity.findAll();
        menuVo.setMenu(menu);
        menuVo.setMenuCenter(centers);

        return menuVo;
    }

    public void save(Menu menu) {
        menuResposity.save(menu);
    }
}
