package com.develop.prd.service;

import com.develop.prd.model.Organize;
import com.develop.prd.repository.OrganizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrganizeService {

    @Autowired
    private OrganizeRepository organizeRepository;

    public void save(Organize organize) {
        //organize.setOrganizeId(UUID.randomUUID().toString());
        organize.setCreateTime(new Date());
        organize.setOrganizeStatus(1);
        organizeRepository.save(organize);
    }

    public List<Organize> list() {
        List<Organize> organizes = organizeRepository.findAll();
        return organizes;
    }
}
