package com.viettel.task.daoImpl;

import org.springframework.stereotype.Repository;

import com.viettel.task.dao.AbstractDao;
import com.viettel.task.dao.EduCourseDao;
import com.viettel.task.model.EduCourse;

@Repository("eduCourseDao")
public class EduCourseDaoImpl extends AbstractDao<Integer, EduCourse>implements EduCourseDao {

	public EduCourse findById(int eduCourseId) {
		return getByKey(eduCourseId);
	}
}