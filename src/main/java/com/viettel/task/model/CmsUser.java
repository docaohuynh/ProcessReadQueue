package com.viettel.task.model;
 
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
 
@Entity
@Table(name="cms_users")
public class CmsUser {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private int userId;
 
    @Size(min=1, max=450)
    @Column(name = "username", nullable = false)
    private String username;
    
    @Size(min=1, max=450)
    @Column(name = "full_name", nullable = false)
    private String fullName;
    
    @Size(min=1, max=450)
    @Column(name = "email", nullable = false)
    private String email;
    
    @Size(min=1, max=450)
    @Column(name = "phone", nullable = false)
    private String phone;
    
    @Size(min=1, max=450)
    @Column(name = "domain", nullable = false)
    private String domain;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}
}