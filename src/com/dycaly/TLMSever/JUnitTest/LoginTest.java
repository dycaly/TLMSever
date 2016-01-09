package com.dycaly.TLMSever.JUnitTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dycaly.TLMSever.Manage.UserManage;

public class LoginTest {

//	private Session session;
//	private Transaction transaction;

	@Before
	public void setUp() throws Exception {
//		session = HibernateSessionFactory.getSession();
//		transaction = session.beginTransaction();
	}

	@After
	public void tearDown() throws Exception {
//		transaction.commit();
//		session.close();
	}

	@Test
	public void test() {
		String username = "dycaly";
		String password = "nfs12345";

		UserManage um = new UserManage(username, password);
		
		if (um.isExist()) {
			System.out.println("��¼�ɹ�:"+um.getToken());
		}
		else {
			System.out.println("�û�����������");
		}
		um.close();
//		String hql = " select u.token from User u where u.username='"
//				+ username + "'and u.password='" + password + "' ";
//		Query query = session.createQuery(hql);
//		
//		String token = (String) query.uniqueResult();
//		
//		if (token != null) {
//			System.out.println("��¼�ɹ���token:"+token);
//		}
//		else {
//			System.out.println("�û�����������");
//		}
	}

}
