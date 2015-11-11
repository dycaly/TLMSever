package com.dycaly.TLMSever.Result;

import java.util.ArrayList;

public class HomeResult {

	private int status;
	private ArrayList<HomeInfo> homeInfos;
	
	public HomeResult(int status){
		this.status = status;
		homeInfos = new ArrayList<HomeInfo>();
	}
	public void addProductID(HomeInfo hi){
		homeInfos.add(hi);
	}
	
}
