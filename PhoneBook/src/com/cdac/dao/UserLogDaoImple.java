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
import com.cdac.dto.UserLogs;

@Repository
public class UserLogDaoImple implements UserLogDao{

	@Autowired
	private HibernateTemplate hibernateTemplate; 
	@Override
	public void insertTimeDateLogs(UserLogs log) {
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				session.save(log);
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
			
			
			
		});

	}
	@Override
	public void updatelogout(String strDate,int userId) {
	
		hibernateTemplate.execute(new HibernateCallback<Void>() {

			@Override
			public Void doInHibernate(Session session) throws HibernateException {
				Transaction tr = session.beginTransaction();
				Query q=session.createQuery("from UserLogs where userId=? order by logId desc").setFirstResult(0)
					.setMaxResults(1);
				q.setInteger(0,userId);
				List<UserLogs> li =q.list();
				int contactId=0;
				for(UserLogs user:li) {
					contactId=user.getLogId();
				}
				
				Query d=session.createQuery("update UserLogs set LogOutDateTime=? where logId=?");
				d.setString(0,strDate);
				d.setInteger(1,contactId);
				d.executeUpdate();
				
				tr.commit();
				session.flush();
				session.close();
				return null;
			}
									
		});
		
	}
	
	@Override
	public List<UserLogs> selectUserLogs() {
		List<UserLogs> logsList= hibernateTemplate.execute(new HibernateCallback<List<UserLogs>>() {

			@Override
			public List<UserLogs> doInHibernate(Session session) throws HibernateException {
				Transaction tr=session.beginTransaction();
				Query q=session.createQuery("from UserLogs");
				List<UserLogs> li=q.list();
				//System.out.println(li);
				tr.commit();
				session.flush();
				session.close();
				return li;
		
			}
		
		}); 
		
		return logsList;
		
	}

}
