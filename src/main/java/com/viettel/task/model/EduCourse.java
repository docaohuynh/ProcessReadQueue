package com.viettel.task.model;
 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
 
@Entity
@Table(name="edu_course")
public class EduCourse {
 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int eduCourseId;
 
    @Size(min=1, max=450)
    @Column(name = "name")
    private String name;
    
    @Size(min=1, max=450)
    @Column(name = "description")
    private String description;
    
    @Size(min=1, max=450)
    @Column(name = "created_user")
    private String createdUser;
    
    @Column(name = "status")
    private Integer status;
    
    @Column(name = "created_time")
    private Date createdTime;
    
    @Column(name = "modified_time")
    private Date modifiedTime;

	public int getEduCourseId() {
		return eduCourseId;
	}

	public void setEduCourseId(int eduCourseId) {
		this.eduCourseId = eduCourseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
    
}