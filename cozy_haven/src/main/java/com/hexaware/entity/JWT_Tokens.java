package com.hexaware.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class JWT_Tokens {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int token_id;
	
	private String token;
	
	@Column(name="issue_date")
	private LocalDateTime issueDate;
	
	@Column(name="expiry_date")
	private LocalDateTime expiryDate;
	
	@Column(name="is_valid")
	private boolean isValid;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;

	public JWT_Tokens(String token, LocalDateTime issueDate, LocalDateTime expiryDate, boolean isValid, User user) {
		super();
		this.token = token;
		this.issueDate = issueDate;
		this.expiryDate = expiryDate;
		this.isValid = isValid;
		this.user = user;
	}

	public int getToken_id() {
		return token_id;
	}

	public void setToken_id(int token_id) {
		this.token_id = token_id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDateTime getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDateTime issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	

}
