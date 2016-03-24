package com.viettel.task.dao;
 
import com.viettel.task.model.CmsUser;
 
 
public interface CmsUserDao {
 
	CmsUser findById(int cmsUserId);
     
}