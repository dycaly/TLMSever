package com.dycaly.TLMSever.JUnitTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.dycaly.TLMSever.Manage.SearchUserManage;

public class SearchResultTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		SearchUserManage sum = new SearchUserManage("dycaly", 1);
		System.out.println(sum.getJson());
	}

}
