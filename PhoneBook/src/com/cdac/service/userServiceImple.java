package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.UserDao;
import com.cdac.dto.User;

@Service
public class userServiceImple implements userService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public void addUser(User user) {
		userDao.insertUser(user);
	}

	@Override
	public boolean findUser(User user) {
		
		return userDao.checkUser(user);
	}

	@Override
	public User loadUser(int userId) {
		
		return userDao.getUser(userId);
	}

	@Override
	public void modifyUser(User user) {
		userDao.updateUser(user);
		
	}

	@Override
	public List<User> selectAll() {
		
		return userDao.selectAll();
	}

	@Override
	public void removeUser(int userId) {
		userDao.removeUser(userId);
		
	}

	@Override
	public void modifyPermission(int userId) {
		userDao.modifyPermission(userId);
		
	}
	
	@Override
	public String forgotPassword(String emailId) {
		return userDao.forgotPassword(emailId);
	}
	
	@Override
	public void uploadImage(String profilePic, int userId) {
		userDao.uploadImage(profilePic, userId);
	}

}
