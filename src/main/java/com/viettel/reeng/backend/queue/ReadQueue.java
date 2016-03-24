package com.viettel.reeng.backend.queue;

public class ReadQueue {
	private String userid;
	private String subjectid;
	private String[] quesitionsid;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(String subjectid) {
		this.subjectid = subjectid;
	}
	public String[] getQuesitionsid() {
		return quesitionsid;
	}
	public void setQuesitionsid(String[] quesitionsid) {
		this.quesitionsid = quesitionsid;
	}
	
}
