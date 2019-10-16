package com.develop.prd.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "t_account")
public class Account {
    @Id
    @Column(name = "account_id")
    private String accountId;
    @Column(name = "account_name")
    private String accountName;
    @Column(name = "account_realName")
    private String accountRealName;
    @Column(name = "account_password")
    private String accountPassword;
    @Column(name = "account_gender")
    private Integer accountGender;
    @Column(name = "account_tel")
    private String accountTel;
    @Column(name = "account_dept")
    private Integer accountDept;
    @Column(name = "account_job")
    private String accountJob;
    @Column(name = "account_role")
    private Integer accountRole;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "status")
    private Integer status;

}
