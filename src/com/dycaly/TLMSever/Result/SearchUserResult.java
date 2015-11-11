package com.dycaly.TLMSever.Result;

import java.util.ArrayList;

public class SearchUserResult {

	private int status;
	private ArrayList<UserNick_Name> results;
	public SearchUserResult(int status) {
		this.status = status;
		results = new ArrayList<UserNick_Name>();
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public ArrayList<UserNick_Name> getResults() {
		return results;
	}
	public void setResults(ArrayList<UserNick_Name> results) {
		this.results = results;
	}
	
	public void addItem(UserNick_Name unm){
		results.add(unm);
	}
	
	
}
