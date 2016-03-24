package com.viettel.task.serviceImpl;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.viettel.task.dao.EduQuestionDao;
import com.viettel.task.model.EduQuestion;
import com.viettel.task.service.EduQuestionService;
 
 
@Service("eduQuestionService")
@Transactional
public class EduQuestionServiceImpl implements EduQuestionService {
 
    @Autowired
    private EduQuestionDao dao;
     
    public EduQuestion findById(int id) {
        return dao.findById(id);
    }
 
}