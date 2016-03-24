package com.viettel.task.daoImpl;

import org.springframework.stereotype.Repository;

import com.viettel.task.dao.AbstractDao;
import com.viettel.task.dao.EduResourceDao;
import com.viettel.task.model.EduResource;

@Repository("eduResourceDao")
public class EduResourceDaoImpl extends AbstractDao<Integer, EduResource>implements EduResourceDao {

	public EduResource findById(int eduResourceId) {
		return getByKey(eduResourceId);
	}
}