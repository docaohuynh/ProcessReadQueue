package com.viettel.task.model;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
 
@Entity
@Table(name="edu_answer")
public class EduAnswer {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int eduAnswerId;
 
    @Size(min=1, max=450)
    @Column(name = "content", nullable = false)
    private String content;
    
    @Column(name = "question_id")
    private Integer questionId;
    
    @Column(name = "is_correct")
    private Integer isCorrect;

	public int getEduAnswerId() {
		return eduAnswerId;
	}

	public void setEduAnswerId(int eduAnswerId) {
		this.eduAnswerId = eduAnswerId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Integer getIsCorrect() {
		return isCorrect;
	}

	public void setIsCorrect(Integer isCorrect) {
		this.isCorrect = isCorrect;
	}
    
}