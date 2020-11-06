package com.cdac.dao;

import java.util.List;

import com.cdac.dto.Contact;

public interface ContactDao {

	void insertContact(Contact contact);
	void deleteContact(int contactId);
	void removeUserData(int userId);
	Contact selectContact(int contactId);
	void updateContact(Contact contact);
	List<Contact> selectAll(int userId);
	List<Contact> selectAllAscName(int userId);
	List<Contact> selectAllDescName(int userId);
	List<Contact> selectSearchByName(int userId,String searchVal);
	
}
