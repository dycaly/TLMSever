package com.dycaly.TLMSever.Result;

import java.util.ArrayList;

public class FriendsResult {

	
	private int status;
	private ArrayList<FriendInfo> friends;
	
	public FriendsResult(int status){
		this.status =status;
		friends = new ArrayList<FriendInfo>();
	}
	public void addFriendinfo(FriendInfo friendInfo){
		friends.add(friendInfo);
	}
}
