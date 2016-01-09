package com.dycaly.TLMSever.JUnitTest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dycaly.TLMSever.Entity.User;
import com.dycaly.TLMSever.Manage.HibernateSessionFactory;

public class UpdatePW {

	
	private Session session;
	private Transaction transaction;
	@Before
	public void setUp() throws Exception {
		session = HibernateSessionFactory.getSession();
		transaction = session.beginTransaction();
	}

	@After
	public void tearDown() throws Exception {
		transaction.commit();
		session.close();
	}

	@Test
	public void test() {
		String token = "dycaly_dyc19950807";
		String nPassword = "nfs123456";
		
		String hql = "from User u where u.token='"+token+"' ";
		Query query = session.createQuery(hql);
		User user = (User) query.uniqueResult();
		if (user != null) {
			user.setPassword(nPassword);
			user.setToken(user.getUsername()+"_"+nPassword);
			session.update(user);
			System.out.println("password:"+nPassword);
		}
		else {
			System.out.println("用户不存在");
		}
		
	}

}
