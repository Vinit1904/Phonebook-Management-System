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
public class UserDaoImple implements UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Autowired
	private ContactDao contactDao;
	
	@Override	
	public void insertUser(User user) {
		
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.save(user);
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
			
			
		});
		
	}

	@Override
	public boolean checkUser(User user) {
		boolean b= hibernateTemplate.execute(new HibernateCallback<Boolean>() {
			
			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				Transaction tr=session.beginTransaction();
				Query q=session.createQuery("from User where emailId=? and userPass=?");
				q.setString(0,user.getEmailId());
				q.setString(1,user.getUserPass());
				List<User> li=q.list();
				boolean flag =!li.isEmpty();
				if(flag) {
				user.setUserId(li.get(0).getUserId());
				user.setFirstName(li.get(0).getFirstName());
				user.setRoll(li.get(0).getRoll());
				
				//System.out.println(user);
				}
				tr.commit();
				session.flush();
				session.close();
				return flag;
			}
			
			
		});
		return b;
	}

	@Override
	public User getUser(int userId) {
		
		User user = hibernateTemplate.execute(new HibernateCallback<User>() {

			@Override
			public User doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				 User ur = (User)session.get(User.class, userId);
				 //System.out.println("ur"+ur);
				 tr.commit();
				session.flush();
				session.close();
				return ur;
				
			}
			
		});
		return user;
	}
	
	
	

	@Override
	public String forgotPassword(String emailId) {
		String password = hibernateTemplate.execute(new HibernateCallback<String>() {

			@Override
			public String doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q = session.createQuery("from User where emailId = ?");
				q.setString(0, emailId);
				List<User> li = q.list();
				String pass = null;
				if(!li.isEmpty())
					pass = li.get(0).getUserPass();
				tr.commit();
				session.flush();
				session.close();
				return pass;
			}
			
		});
		return password;
	}

	
	@Override
	public void uploadImage(String profilePic,int userId) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				User user = (User)session.get(User.class, userId);
				user.setProfilePic(profilePic); 
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
		});
	}
	
	
	
	@Override
	public void updateUser(User user) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				
				 Transaction tr=session.beginTransaction();
				 session.update(user);
				 tr.commit();
				 session.flush();
				 session.close();				
				return null;
			}
		});
		
	}

	@Override
	public List<User> selectAll() {
		
		List<User> userList= hibernateTemplate.execute(new HibernateCallback<List<User>>() {

			@Override
			public List<User> doInHibernate(Session session) throws HibernateException {
				Transaction tr=session.beginTransaction();
				Query q=session.createQuery("from User");
				List<User> li=q.list();
				//System.out.println(li);
				tr.commit();
				session.flush();
				session.close();
				return li;
		
			}
		
		});
		return userList;
	}

	@Override
	public void removeUser(int userId) {

		List<User> userList= hibernateTemplate.execute(new HibernateCallback<List<User>>() {

			@Override
			public List<User> doInHibernate(Session session) throws HibernateException {
				Transaction tr=session.beginTransaction();
				session.delete(new User(userId));
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
		
		});

	}

	@Override
	public void modifyPermission(int userId) {
		
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				
				 Transaction tr=session.beginTransaction();
				 Query q=session.createQuery("update User set roll=? where userId=? ");
				 q.setString(0,"Admin");
				 q.setInteger(1,userId);
				 q.executeUpdate();
				 tr.commit();
				 session.flush();
				 session.close();				
				return null;
			}
		});

	}

	
	
}
