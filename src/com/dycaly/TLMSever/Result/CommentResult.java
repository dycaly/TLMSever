package com.dycaly.TLMSever.Result;

import java.util.ArrayList;

public class CommentResult {

	private int status;
	private ArrayList<CommentInfo> commentInfos;
	
	public CommentResult(int status) {
		this.status =status;
		commentInfos = new ArrayList<CommentInfo>();
	}
	public void addCommentInfo(CommentInfo ci){
		commentInfos.add(ci);
	}
}
