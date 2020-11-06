package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.UserLogDao;
import com.cdac.dto.UserLogs;

@Service
public class userLogsServicesImple implements userLogsServices {
	
	@Autowired
	private UserLogDao userLogDao;
	
	
	@Override
	public void insertTimeDateLogs(UserLogs log) {
		
		userLogDao.insertTimeDateLogs(log);
	}


	@Override
	public void updatelogout(String strDate,int userId) {
		userLogDao.updatelogout(strDate,userId);
	}


	@Override
	public List<UserLogs> selectUserLogs() {
		
		return userLogDao.selectUserLogs();
	}

}
