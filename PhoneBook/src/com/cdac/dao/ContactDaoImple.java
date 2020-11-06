package com.cdac.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cdac.dto.Contact;
import com.cdac.dto.User;

@Repository
public class ContactDaoImple implements ContactDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	
	@Override
	public void insertContact(Contact contact) {
		
		//System.out.println("");
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.save(contact);
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
		
	}


	
	@Override
	public void deleteContact(int contactId) {
		
		
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				
				 Transaction tr=session.beginTransaction();
				 //session.save(new Contact(contactId));
				 session.delete(new Contact(contactId));
				 tr.commit();
				 session.flush();
				 session.close();				
				return null;
			}
		});
		
	}

	@Override
	public Contact selectContact(int contactId) {
		
		Contact contact=hibernateTemplate.execute(new HibernateCallback<Contact>(){

			@Override
			public Contact doInHibernate(Session session) throws HibernateException {
				
				Transaction tr=session.beginTransaction();
				 Contact ct=(Contact) session.get(Contact.class,contactId);
				 tr.commit();
				 session.flush();
				 session.close();				
				return ct;
			}
		 
		});
		
		
		return contact;
	}

	@Override
	public void updateContact(Contact contact) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				
				 Transaction tr=session.beginTransaction();
				 session.update(contact);
				 tr.commit();
				 session.flush();
				 session.close();				
				return null;
			}
		});
		
	}

	@Override
	public List<Contact> selectAll(int userId) {
		List<Contact> contactList= hibernateTemplate.execute(new HibernateCallback<List<Contact>>() {

			@Override
			public List<Contact> doInHibernate(Session session) throws HibernateException {
				Transaction tr=session.beginTransaction();
				Query q=session.createQuery("from Contact where userId=? ");
				q.setInteger(0,userId);
				List<Contact> li=q.list();
				System.out.println(li);
				tr.commit();
				session.flush();
				session.close();
				return li;
		
			}
		
		}); 
		
		return contactList;
	}



	@Override
	public void removeUserData(int userId) {
			
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				
				 Transaction tr=session.beginTransaction();
				 Query q=session.createQuery("delete from Contact where userId=? ");
				 q.setInteger(0,userId);
				 q.executeUpdate();
				 tr.commit();
				 session.flush();
				 session.close();				
				return null;
			}
		});
		
	}



	@Override
	public List<Contact> selectAllAscName(int userId) {
			
		List<Contact> contactList= hibernateTemplate.execute(new HibernateCallback<List<Contact>>() {

			@Override
			public List<Contact> doInHibernate(Session session) throws HibernateException {
				Transaction tr=session.beginTransaction();
				Query q=session.createQuery("from Contact where userId=? ORDER BY name");
				q.setInteger(0,userId);
				List<Contact> li=q.list();
				//System.out.println(li);
				tr.commit();
				session.flush();
				session.close();
				return li;
		
			}
		
		});
		return contactList;
	}



	@Override
	public List<Contact> selectAllDescName(int userId) {
			
		List<Contact> contactList= hibernateTemplate.execute(new HibernateCallback<List<Contact>>() {

			@Override
			public List<Contact> doInHibernate(Session session) throws HibernateException {
				Transaction tr=session.beginTransaction();
				Query q=session.createQuery("from Contact where userId=? ORDER BY name desc");
				q.setInteger(0,userId);
				List<Contact> li=q.list();
				//System.out.println(li);
				tr.commit();
				session.flush();
				session.close();
				return li;
		
			}
		
		});
		return contactList;
	}



	@Override
	public List<Contact> selectSearchByName(int userId,String searchVal) {
			
		List<Contact> contactList= hibernateTemplate.execute(new HibernateCallback<List<Contact>>() {

			@Override
			public List<Contact> doInHibernate(Session session) throws HibernateException {
				Transaction tr=session.beginTransaction();
				Query q=session.createQuery("from Contact where userId=? and name like ?");
				q.setInteger(0, userId);
				q.setString(1, '%'+searchVal+'%');
				List<Contact> li=q.list();
				//System.out.println(li);
				tr.commit();
				session.flush();
				session.close();
				return li;
		
			}
		
		});
		return contactList;
	}

}
