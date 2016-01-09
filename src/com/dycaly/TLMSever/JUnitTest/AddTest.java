package com.dycaly.TLMSever.JUnitTest;

import java.sql.Timestamp;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dycaly.TLMSever.Entity.User;
import com.dycaly.TLMSever.Entity.Userditals;
import com.dycaly.TLMSever.Manage.HibernateSessionFactory;



public class AddTest {

	private Session session;
	
	@Before
	public void setUp() throws Exception {
		session = HibernateSessionFactory.getSession();
	}

	@After
	public void tearDown() throws Exception {
		session.close();
	}

	@Test
	public void test() {
		String username = "haha";
		String password = "123";
		
		String hqlSame = " from User u where u.username = '"+username +"' ";
		Query query = session.createQuery(hqlSame);
		User user = (User) query.uniqueResult();
		
		if (user ==null) {
			
			String hqlId = " select u.userId from User u where u.userId >=ALL(select u.userId from u)";
			Query queryId = session.createQuery(hqlId);
			int id = (int) queryId.uniqueResult();
			
			id++;
			Transaction transaction = (Transaction) session.beginTransaction();
			session.save(new User(id, username, password, username+"_"+password, 0));
			Userditals ud = new Userditals();
			ud.setUser(user);
			ud.setUserId(id);
			ud.setRegdate(new Timestamp(System.currentTimeMillis()));
			session.save(ud);
			transaction.commit();
		}
		else {
			System.out.println("�û����ظ���");
		}
	}

}
