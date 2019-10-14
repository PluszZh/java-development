package com.develop.prd.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table( name = "t_menu")
public class Menu {

    @Id
    @Column(name = "menu_id")
    private String menuId;

    @Column(name = "menu_name")
    private String menuName;

    /*@Column(name = "menu_parent")
    private Integer menuParent;*/

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_parent")
    private MenuCenter menuCenter;

    @Column(name = "menuOrder")
    private Integer menuOrder;

    @Column(name = "menu_description")
    private String menuDescription;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "menu_creator")
    private String menuCreator;

}
