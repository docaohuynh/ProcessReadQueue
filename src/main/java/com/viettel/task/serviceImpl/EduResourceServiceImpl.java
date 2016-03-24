package com.viettel.task.serviceImpl;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.viettel.task.dao.EduResourceDao;
import com.viettel.task.model.EduResource;
import com.viettel.task.service.EduResourceService;
 
 
@Service("eduResourceService")
@Transactional
public class EduResourceServiceImpl implements EduResourceService {
 
    @Autowired
    private EduResourceDao dao;
     
    public EduResource findById(int id) {
        return dao.findById(id);
    }
 
}