package com.dycaly.TLMSever.Manage;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dycaly.TLMSever.Entity.Home;
import com.dycaly.TLMSever.Result.HomeInfo;
import com.dycaly.TLMSever.Result.HomeResult;
import com.google.gson.Gson;

public class HomeManage {

	private Session session;
	
	public HomeManage() {
		session = HibernateSessionFactory.getSession();
	}
	public String getHomesJson(){
		String result = null;
		
		HomeResult homeResult = new HomeResult(0);
		String hql = "from Home";
		Query query = session.createQuery(hql);
		ArrayList<Home> homes = (ArrayList<Home>) query.list();
		
		for (Home home : homes) {
			homeResult.addProductID(new HomeInfo(home.getProduct().getProductId(), home.getWhich()));
		}
		Gson gson = new Gson();
		result = gson.toJson(homeResult);
		return result;
	}
	public void close(){
		session.close();
	}
}
