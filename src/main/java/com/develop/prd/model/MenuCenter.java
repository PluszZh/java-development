package com.develop.prd.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_center")
public class MenuCenter {
    @Id
    @Column(name = "center_id")
    private Integer centerId;
    @Column(name = "center_name")
    private String centerName;
    @Column(name = "type_id")
    private Integer typeId;
    @Column(name = "child_num")
    private Integer childNum;
}
