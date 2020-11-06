package com.cdac.service;

import java.util.List;

import com.cdac.dto.Contact;

public interface ContactService {
	
	 void addContact(Contact contact);
	 void removeContact(int contactId);
	 Contact findContact(int contactId);
	 void modifyContact(Contact contact);
	 List<Contact> selectAll(int userId);
	 void removeUserData(int userId);
	 List<Contact> selectAllAscName(int userId);
	 List<Contact> selectAllDescName(int userId);
	 List<Contact> selectSearchByName(int userId,String searchVal);
}
