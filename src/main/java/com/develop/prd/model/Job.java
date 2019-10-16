package com.develop.prd.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "t_job")
public class Job {
    @Id
    @Column(name = "job_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer jobId;
    @Column(name = "job_name")
    private String jobName;
    @Column(name = "job_description")
    private String jobDescription;
    @Column(name = "create_time")
    private Date createTime;
}
