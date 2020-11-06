package com.cdac.service;


import java.util.List;

import com.cdac.dto.Contact;
import com.cdac.dto.User;

public interface userService {

	void addUser(User user);
	boolean findUser(User user);
	void modifyUser(User user);
	User loadUser(int userId);
	List<User> selectAll();
	void removeUser(int userId);
	void modifyPermission(int userId);
	String forgotPassword(String emailId);
	void uploadImage(String profilePic,int userId);
	
}
