package com.viettel.task.daoImpl;

import org.springframework.stereotype.Repository;

import com.viettel.task.dao.AbstractDao;
import com.viettel.task.dao.EduSubjectDao;
import com.viettel.task.model.EduSubject;

@Repository("eduSubjectDao")
public class EduSubjectDaoImpl extends AbstractDao<Integer, EduSubject>implements EduSubjectDao {

	public EduSubject findById(int eduSubjectId) {
		return getByKey(eduSubjectId);
	}
}