package com.dycaly.TLMSever.JUnitTest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dycaly.TLMSever.Entity.Userditals;
import com.dycaly.TLMSever.Manage.HibernateSessionFactory;

public class SetUserDitals {

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
			String token = "haha_123";
			
			String picUrl = null;
			String nickname = "hyk";
			String name = "胡亚坤";
			int age = 21;
			int sex = 0;
			String school = "北航";
			String college = "计算机学院";
			String email = "12345@qq.com";
			String phone = "1666767666";
			
			String hql = " from Userditals ud where ud.userId in (select u.userId from User u where u.token='"
					+ token + "')";
			Query query = session.createQuery(hql);
			Userditals ud = (Userditals) query.uniqueResult();
			
			if (ud != null) {
				
				ud.setPicUrl(picUrl);
				ud.setNickname(nickname);
				ud.setName(name);
				ud.setAge(age);
				ud.setSex(sex);
				ud.setSchool(school);
				ud.setCollege(college);
				ud.setEmail(email);
				ud.setPhone(phone);
				
				session.update(ud);
				
				System.out.println("修改成功");
			}
			else {
				System.out.println("修改失败");
			}
			
	}

}
