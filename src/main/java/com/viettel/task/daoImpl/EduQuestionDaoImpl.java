package com.viettel.task.daoImpl;

import org.springframework.stereotype.Repository;

import com.viettel.task.dao.AbstractDao;
import com.viettel.task.dao.EduQuestionDao;
import com.viettel.task.model.EduQuestion;

@Repository("eduQuestionDao")
public class EduQuestionDaoImpl extends AbstractDao<Integer, EduQuestion>implements EduQuestionDao {

	public EduQuestion findById(int eduQuestionId) {
		return getByKey(eduQuestionId);
	}
}