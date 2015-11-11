package com.dycaly.TLMSever.Result;

public class MessageInfo {

	private String sender;
	private String nickname;
	private String receiver;
	private String content;
	private String time;
	public MessageInfo(String sender,String nickname, String receiver, String content,
			String time) {
		this.sender = sender;
		this.nickname = nickname;
		this.receiver = receiver;
		this.content = content;
		this.time = time;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
