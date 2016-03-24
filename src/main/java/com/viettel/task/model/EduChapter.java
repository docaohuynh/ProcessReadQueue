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
@Table(name="edu_chapter")
public class EduChapter {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int eduChapterId;
 
    @Size(min=1, max=450)
    @Column(name = "name")
    private String name;
    
    @Size(min=1, max=450)
    @Column(name = "description")
    private String description;
    
    @Column(name = "level")
    private Integer level;
    
    @Column(name = "status")
    private Integer status;
    
    @Column(name = "parent_id")
    private Integer parentId;
    
    @Column(name = "subject_id")
    private Integer subjectId;
    
    @Column(name = "created_time")
    private Date createdTime;
    
    @Column(name = "modified_time")
    private Date modifiedTime;

	public int getEduChapterId() {
		return eduChapterId;
	}

	public void setEduChapterId(int eduChapterId) {
		this.eduChapterId = eduChapterId;
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

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
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