package com.dycaly.TLMSever.JUnitTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dycaly.TLMSever.Manage.UserManage;

public class ReqAddFriend {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		UserManage um1=new UserManage(5);
		um1.reqAddFriend("15583675009");
	}

}
