package com.dycaly.TLMSever.Result;

import java.util.ArrayList;

public class MessageResult {

	private int status;
	private ArrayList<MessageInfo> messages;
	
	public MessageResult(int status) {
		this.status = status;
		messages = new ArrayList<MessageInfo>();
	}
	public void addMessageInfo(MessageInfo mi){
		messages.add(mi);
	}
}
