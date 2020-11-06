package com.cdac.dao;


import java.util.List;

import com.cdac.dto.Contact;
import com.cdac.dto.User;

public interface UserDao {

	void insertUser(User user);
	boolean checkUser(User user);
	void updateUser(User user);
	User getUser(int userId);
	List<User> selectAll();
	void removeUser(int userId);
	void modifyPermission(int userId);
	String forgotPassword(String emailId);
	void uploadImage(String profilePic,int userId);
	
}
