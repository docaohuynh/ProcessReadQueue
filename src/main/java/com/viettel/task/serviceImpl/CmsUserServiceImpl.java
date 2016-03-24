package com.viettel.task.serviceImpl;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.viettel.task.dao.CmsUserDao;
import com.viettel.task.model.CmsUser;
import com.viettel.task.service.CmsUserService;
 
 
@Service("cmsUserService")
@Transactional
public class CmsUserServiceImpl implements CmsUserService {
 
    @Autowired
    private CmsUserDao dao;
     
    public CmsUser findById(int id) {
        return dao.findById(id);
    }
 
}