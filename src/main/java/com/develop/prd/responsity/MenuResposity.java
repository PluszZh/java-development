package com.develop.prd.responsity;

import com.develop.prd.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuResposity extends JpaRepository<Menu,String> {

    List<Menu> findByMenuNameLike(String menuName);
}
