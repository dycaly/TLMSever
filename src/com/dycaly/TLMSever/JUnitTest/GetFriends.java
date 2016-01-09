package com.dycaly.TLMSever.JUnitTest;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dycaly.TLMSever.Manage.UserManage;

public class GetFriends {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		UserManage um = new UserManage(5);
		ArrayList<String> friends=  um.getFriends();
		
		System.out.println("----start----"+friends.size()+"--");
		for(String str :friends){
			System.out.println(str);
		}
		System.out.println("----end----");
		um.close();
	}
	

}
