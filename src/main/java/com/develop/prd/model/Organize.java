package com.develop.prd.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "t_organize")
public class Organize {
    @Id
    @Column(name = "organize_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer organizeId;
    @Column(name = "organize_name")
    private String organizeName;
    @Column(name = "organize_parent")
    private String organizeParent;
    @Column(name = "organize_description")
    private String organizeDescription;
    @Column(name = "organize_status")
    private Integer organizeStatus;
    @Column(name = "create_time")
    private Date createTime;
}
