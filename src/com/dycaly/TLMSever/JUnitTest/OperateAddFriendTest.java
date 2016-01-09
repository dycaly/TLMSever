package com.dycaly.TLMSever.JUnitTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dycaly.TLMSever.Manage.UserManage;

public class OperateAddFriendTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		UserManage umManage = new UserManage("15583675009",2015111);
		umManage.operateAddFriend("trsTest", 0);
	}

}
