package com.viettel.task.daoImpl;

import org.springframework.stereotype.Repository;

import com.viettel.task.dao.AbstractDao;
import com.viettel.task.dao.EduChapterDao;
import com.viettel.task.model.EduChapter;

@Repository("eduChapterDao")
public class EduChapterDaoImpl extends AbstractDao<Integer, EduChapter>implements EduChapterDao {

	public EduChapter findById(int eduChapterId) {
		return getByKey(eduChapterId);
	}
}