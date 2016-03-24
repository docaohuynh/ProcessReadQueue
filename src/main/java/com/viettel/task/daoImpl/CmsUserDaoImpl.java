package com.viettel.task.daoImpl;

import org.springframework.stereotype.Repository;

import com.viettel.task.dao.AbstractDao;
import com.viettel.task.dao.CmsUserDao;
import com.viettel.task.model.CmsUser;

@Repository("cmsUserDao")
public class CmsUserDaoImpl extends AbstractDao<Integer, CmsUser>implements CmsUserDao {

	public CmsUser findById(int cmsUserId) {
		return getByKey(cmsUserId);
	}
}