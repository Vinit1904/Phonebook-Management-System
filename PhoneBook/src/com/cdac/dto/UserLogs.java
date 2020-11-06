package com.cdac.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_log")
public class UserLogs {



	@Id
	@GeneratedValue
	@Column(name="log_id")
	private int logId;
	
	@Column(name="log_in_date_time")
	private String LogInDateTime;
	
	@Column(name="log_out_date_time")
	private String LogOutDateTime;
	
	@Column(name="user_Id")
	private int userId;

	public UserLogs() {

	}


	
	public UserLogs(String logInDateTime, int userId) {
		LogInDateTime = logInDateTime;
		this.userId = userId;
	}



	public int getLogId() {
		return logId;
	}



	public void setLogId(int logId) {
		this.logId = logId;
	}



	public String getLogInDateTime() {
		return LogInDateTime;
	}



	public void setLogInDateTime(String logInDateTime) {
		LogInDateTime = logInDateTime;
	}



	public String getLogOutDateTime() {
		return LogOutDateTime;
	}



	public void setLogOutDateTime(String logOutDateTime) {
		LogOutDateTime = logOutDateTime;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	@Override
	public String toString() {
		return "UserLogs [logId=" + logId + ", LogInDateTime=" + LogInDateTime + ", LogOutDateTime=" + LogOutDateTime
				+ "]";
	}
	
}
