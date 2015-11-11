package com.dycaly.TLMSever.Result;

import java.util.ArrayList;

public class ReqAddFriendResult {

	private int status;
	private ArrayList<ReqAddFriendInfo> reqs;
	
	public ReqAddFriendResult(int status) {
		this.status =status;
		reqs = new ArrayList<ReqAddFriendInfo>();
	}
	public void addReqAddFriendInfo(ReqAddFriendInfo item){
		reqs.add(item);
	}
}
