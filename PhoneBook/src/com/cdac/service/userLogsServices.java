package com.cdac.service;

import java.util.List;

import com.cdac.dto.UserLogs;

public interface userLogsServices {

	void insertTimeDateLogs(UserLogs log);
	void updatelogout(String strDate,int userId);
	List<UserLogs> selectUserLogs();
}
