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
@Table(name="edu_subject")
public class EduSubject {
 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int eduResourceId;
 
    @Size(min=1, max=450)
    @Column(name = "name")
    private String name;
    
    @Size(min=1, max=450)
    @Column(name = "description")
    private String description;
    
    @Column(name = "course_id")
    private Integer courseId;
    
    @Column(name = "status")
    private Integer status;
    
    @Size(min=1, max=450)
    @Column(name = "created_user")
    private String createdUser;
    
    @Column(name = "created_time")
    private Date createdTime;
    
    @Column(name = "modified_time")
    private Date modifiedTime;

	public int getEduResourceId() {
		return eduResourceId;
	}

	public void setEduResourceId(int eduResourceId) {
		this.eduResourceId = eduResourceId;
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

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
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