package com.dycaly.TLMSever.Result;

public class ReqAddFriendInfo {

	private boolean issaw;
	private String url;
	private String susername;
	private String snickname;
	private String rusername;
	private String date;
	public ReqAddFriendInfo(boolean issaw,String url, String susername, String snickname,
			String rusername, String date) {
		this.issaw = issaw;
		this.url = url;
		this.susername = susername;
		this.snickname = snickname;
		this.rusername = rusername;
		this.date = date;
	}
	
	
	
	
}
