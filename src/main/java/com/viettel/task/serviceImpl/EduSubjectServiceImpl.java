package com.viettel.task.serviceImpl;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.viettel.task.dao.EduSubjectDao;
import com.viettel.task.model.EduSubject;
import com.viettel.task.service.EduSubjectService;
 
 
@Service("eduSubjectService")
@Transactional
public class EduSubjectServiceImpl implements EduSubjectService {
 
    @Autowired
    private EduSubjectDao dao;
     
    public EduSubject findById(int id) {
        return dao.findById(id);
    }
 
}