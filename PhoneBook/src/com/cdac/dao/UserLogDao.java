package com.cdac.dao;

import java.util.List;

import com.cdac.dto.UserLogs;

public interface UserLogDao {
	
	void insertTimeDateLogs(UserLogs log);
	void updatelogout(String strDate,int userId);
	List<UserLogs> selectUserLogs();
}
