package com.viettel.task.daoImpl;

import org.springframework.stereotype.Repository;

import com.viettel.task.dao.AbstractDao;
import com.viettel.task.dao.EduAnswerDao;
import com.viettel.task.model.EduAnswer;

@Repository("eduAnswerDao")
public class EduAnswerDaoImpl extends AbstractDao<Integer, EduAnswer>implements EduAnswerDao {

	public EduAnswer findById(int eduAnswerId) {
		return getByKey(eduAnswerId);
	}
}