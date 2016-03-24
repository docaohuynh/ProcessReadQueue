package com.viettel.task.serviceImpl;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.viettel.task.dao.EduChapterDao;
import com.viettel.task.model.EduChapter;
import com.viettel.task.service.EduChapterService;
 
 
@Service("eduChapterService")
@Transactional
public class EduChapterServiceImpl implements EduChapterService {
 
    @Autowired
    private EduChapterDao dao;
     
    public EduChapter findById(int id) {
        return dao.findById(id);
    }
 
}