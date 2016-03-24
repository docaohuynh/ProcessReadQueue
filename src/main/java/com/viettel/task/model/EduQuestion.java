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
@Table(name="edu_question")
public class EduQuestion {
 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int eduQuestionId;
	
	@Column(name = "chapter_id")
    private Integer chapterId;
	
	@Column(name = "resource_id")
    private Integer resourceId;
 
    @Size(min=1, max=5000)
    @Column(name = "content")
    private String content;
    
    @Size(min=1, max=5000)
    @Column(name = "short_explain")
    private String shortExplain;
    
    @Size(min=1, max=5000)
    @Column(name = "full_explain")
    private String fullExplain;
   
    @Column(name = "status")
    private Integer status;
    
    @Column(name = "type")
    private Integer type;
    
    @Column(name = "level")
    private Integer level;
    
    @Size(min=1, max=5000)
    @Column(name = "question_file")
    private String questionFile;
    
    @Size(min=1, max=5000)
    @Column(name = "full_question_file")
    private String fullQuestionFile;
    
    @Column(name = "created_time")
    private Date createdTime;
    
    @Column(name = "modified_time")
    private Date modifiedTime;
    
    @Size(min=1, max=450)
    @Column(name = "created_user")
    private String createdUser;
    
    @Size(min=1, max=450)
    @Column(name = "modified_user")
    private String modifiedUser;

	public int getEduQuestionId() {
		return eduQuestionId;
	}

	public void setEduQuestionId(int eduQuestionId) {
		this.eduQuestionId = eduQuestionId;
	}

	public Integer getChapterId() {
		return chapterId;
	}

	public void setChapterId(Integer chapterId) {
		this.chapterId = chapterId;
	}

	public Integer getResourceId() {
		return resourceId;
	}

	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getShortExplain() {
		return shortExplain;
	}

	public void setShortExplain(String shortExplain) {
		this.shortExplain = shortExplain;
	}

	public String getFullExplain() {
		return fullExplain;
	}

	public void setFullExplain(String fullExplain) {
		this.fullExplain = fullExplain;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getQuestionFile() {
		return questionFile;
	}

	public void setQuestionFile(String questionFile) {
		this.questionFile = questionFile;
	}

	public String getFullQuestionFile() {
		return fullQuestionFile;
	}

	public void setFullQuestionFile(String fullQuestionFile) {
		this.fullQuestionFile = fullQuestionFile;
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

	public String getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}

	public String getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
     
}