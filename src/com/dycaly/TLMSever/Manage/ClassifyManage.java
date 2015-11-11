package com.dycaly.TLMSever.Manage;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.dycaly.TLMSever.Entity.Classify;
import com.dycaly.TLMSever.Entity.Product;
import com.dycaly.TLMSever.Result.ProductInfo;
import com.dycaly.TLMSever.Result.ProductResult;
import com.google.gson.Gson;

public class ClassifyManage {

	private Classify mClassify;
	private Session session;
	
	public ClassifyManage(String classname){
		session = HibernateSessionFactory.getSession();
		String hql="from Classify c where c.name='"+classname+"'";
		Query query = session.createQuery(hql);
		mClassify = (Classify) query.uniqueResult();
	}
	
	public void close(){
		session.close();
	}
	
	public Set<Product> getProducts(){
		return mClassify.getProducts();
	}
	public Classify getClassify(){
		return mClassify;
	}
	public String getProductsJson() {
		String result = null;
		ProductResult pr = new ProductResult(0);
		Set<Product> set = mClassify.getProducts();
		Iterator<Product> iterator = set.iterator();
		while (iterator.hasNext()) {
			Product product = (Product) iterator.next();
			UserDitalsManage udm = new UserDitalsManage(product.getUserBySellerId().getUserId());
			pr.addProductInfo(new ProductInfo(product.getProductId(),product.getProductUrl(), product
					.getProductName(),udm.getUserditals().getNickname(), product.getProductIntro(), product
					.getHightestPrice(), product.getLowestPrice(), product
					.getCutTime(), product.getCutPrice(),product.getStatus(), product
					.getUserBySellerId().getUsername(), product.getSellDate()
					.toString(), product.getUserByBuyerId().getUsername(),
					product.getLastPrice(), product.getClassify().getName()));
		}
		Gson gson = new Gson();
		
		result = gson.toJson(pr); 
		return result;
	}
}
