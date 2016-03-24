package com.viettel.task.serviceImpl;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.viettel.task.dao.EduCourseDao;
import com.viettel.task.model.EduCourse;
import com.viettel.task.service.EduCourseService;
 
 
@Service("eduCourseService")
@Transactional
public class EduCourseServiceImpl implements EduCourseService {
 
    @Autowired
    private EduCourseDao dao;
     
    public EduCourse findById(int id) {
        return dao.findById(id);
    }
 
}