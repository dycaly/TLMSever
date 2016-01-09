package com.dycaly.TLMSever.JUnitTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dycaly.TLMSever.Manage.UserManage;

public class DeleteFriendTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		UserManage um = new UserManage(5);
		um.deleteFriend("15583675009");
		um.close();
	}

}
