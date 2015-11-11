package com.dycaly.TLMSever.Result;

public class CommentInfo {

	private String nickname;
	private String username;
	private String content;
	private String date;
	private int floor;
	public CommentInfo(String nickname, String username, String content,
			String date, int floor) {
		super();
		this.nickname = nickname;
		this.username = username;
		this.content = content;
		this.date = date;
		this.floor = floor;
	}
	
	
}
