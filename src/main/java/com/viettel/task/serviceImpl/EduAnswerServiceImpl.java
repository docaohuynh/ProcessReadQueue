package com.viettel.task.serviceImpl;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.viettel.task.dao.EduAnswerDao;
import com.viettel.task.model.EduAnswer;
import com.viettel.task.service.EduAnswerService;
 
 
@Service("eduAnswerService")
@Transactional
public class EduAnswerServiceImpl implements EduAnswerService {
 
    @Autowired
    private EduAnswerDao dao;
     
    public EduAnswer findById(int id) {
        return dao.findById(id);
    }
 
}