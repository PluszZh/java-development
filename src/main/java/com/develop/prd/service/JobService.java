package com.develop.prd.service;

import com.develop.prd.model.Job;
import com.develop.prd.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> list() {
        return jobRepository.findAll();
    }

    public void save(Job job) {
        if (job.getJobId() == null) {
            job.setCreateTime(new Date());
            jobRepository.save(job);
        }else {
            Job dbJob = findById(job.getJobId());
            dbJob.setJobName(job.getJobName());
            dbJob.setJobDescription(job.getJobDescription());
            jobRepository.save(dbJob);
        }

    }

    public Job findById(Integer id) {
        Optional<Job> optionalJob = jobRepository.findById(id);
        if (optionalJob.isPresent()) {
            return optionalJob.get();
        } else {
            return null;
        }
    }
}
