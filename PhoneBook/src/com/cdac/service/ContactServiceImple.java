package com.cdac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dao.ContactDao;
import com.cdac.dto.Contact;

@Service
public class ContactServiceImple implements ContactService {

	@Autowired
	private ContactDao contactDao;
	
	@Override
	public void addContact(Contact contact) {
		//System.out.println(contact);
		contactDao.insertContact(contact);
	}

	@Override
	public void removeContact(int contactId) {
		contactDao.deleteContact(contactId);
		
	}

	@Override
	public Contact findContact(int contactId) {
		
		return contactDao.selectContact(contactId);
	}

	@Override
	public void modifyContact(Contact contact) {
		contactDao.updateContact(contact);
		
	}

	@Override
	public List<Contact> selectAll(int userId) {
		
		return contactDao.selectAll(userId);
	}

	@Override
	public void removeUserData(int userId) {
		contactDao.removeUserData(userId);;		
	}

	@Override
	public List<Contact> selectAllAscName(int userId) {
		
		return contactDao.selectAllAscName(userId);
	}
	
	@Override
	public List<Contact> selectAllDescName(int userId) {
		
		return contactDao.selectAllDescName(userId);
	}

	@Override
	public List<Contact> selectSearchByName(int userId,String searchVal) {
		
		return contactDao.selectSearchByName(userId,searchVal);
	}

	

	
}
