package com.develop.prd.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "t_user")
public class User {
    @Id
    @Column(name = "user_id")
    private String userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_realname")
    private String userRealName;
    @Column(name = "user_password")
    private String userPassword;
    @Column(name = "user_gender")
    private Integer userGender;
    @Column(name = "user_tel")
    private String userTel;
    @Column(name = "user_dept")
    private Integer userDept;
    @Column(name = "user_job")
    private String userJob;
    @Column(name = "user_role")
    private Integer userRole;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "status")
    private Integer status;

}
