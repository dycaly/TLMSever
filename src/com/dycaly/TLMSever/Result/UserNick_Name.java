package com.dycaly.TLMSever.Result;

public class UserNick_Name {

	private String username;
	private String nickname;
	private String name;
	public UserNick_Name(String username, String nickname,String name) {

		this.username = username;
		this.nickname = nickname;
		this.name=name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	
}
