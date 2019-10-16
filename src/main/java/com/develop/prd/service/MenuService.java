package com.develop.prd.service;

import com.develop.prd.handles.ServiceException;
import com.develop.prd.model.Menu;
import com.develop.prd.model.MenuCenter;
import com.develop.prd.repository.MenuCenterRepository;
import com.develop.prd.repository.MenuRepository;
import com.develop.prd.vo.MenuVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private MenuCenterRepository menuCenterRepository;

    public List<Menu> list(String menuName) {
        List<Menu> menuList;
        if(StringUtils.isBlank(menuName)) {
            menuList = menuRepository.findAll();
        }else {
            menuList = menuRepository.findByMenuNameLike("%" + menuName + "%");
        }


        return menuList;
    }

    public Menu findById(String id) {
        Optional<Menu> menu = menuRepository.findById(id);
        if(menu.isPresent()) {
            return menu.get();
        }else {
            throw new ServiceException("id出错");
        }
    }

    public MenuVo editMenu(String id) {
        MenuVo menuVo = new MenuVo();
        Menu menu = findById(id);
        List<MenuCenter> centers = menuCenterRepository.findAll();
        menuVo.setMenu(menu);
        menuVo.setMenuCenter(centers);

        return menuVo;
    }

    public void save(Menu menu) {
        menuRepository.save(menu);
    }
}
