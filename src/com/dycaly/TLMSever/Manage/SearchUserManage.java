package com.dycaly.TLMSever.Manage;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dycaly.TLMSever.Entity.Userditals;
import com.dycaly.TLMSever.Result.SearchUserResult;
import com.dycaly.TLMSever.Result.UserNick_Name;
import com.google.gson.Gson;

public class SearchUserManage {

	private ArrayList<Userditals> userditals;
	private String name;
	private Session session;
	
	public SearchUserManage(String name,int method) {
		session = HibernateSessionFactory.getSession();
		this.name = name;
		userditals=new ArrayList<Userditals>();
		String hql;
		if (method == 0) {
			hql = "from Userditals ud where ud.nickname='"+name+"'";
		}
		else {
			hql = "from Userditals ud where ud.name='"+name+"'";
		}
		Query query = session.createQuery(hql);
		userditals = (ArrayList<Userditals>) query.list();
	}
	
	public String getJson(){
		String json;
		SearchUserResult sur=new SearchUserResult(0);
		
		for (Userditals ud :userditals) {
			sur.addItem(new UserNick_Name(ud.getUser().getUsername(), ud.getNickname(),ud.getName()));
		}
		Gson gson = new Gson();
		json = gson.toJson(sur);
		return json;
	}
	public void close(){
		session.close();
	}
	
}
