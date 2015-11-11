package com.dycaly.TLMSever.Manage;

import java.util.TimerTask;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dycaly.TLMSever.Entity.Product;

public class MyTask extends TimerTask {

	private int mProductId;
	private int cutprice;
	private int hightestprice;
	private int lowestprice;
	private int lastprice;
	private Session session;
	private Transaction transaction;
	public MyTask(Product mProduct) {
		this.mProductId = mProduct.getProductId();
		this.cutprice = mProduct.getCutPrice();
		this.hightestprice = mProduct.getHightestPrice();
		this.lowestprice = mProduct.getLowestPrice();
		this.lastprice = hightestprice;
		session =HibernateSessionFactory.getSession();
		transaction = session.beginTransaction();
		mProduct.setLastPrice(lastprice);
		session.update(mProduct);
		transaction.commit();
		session.close();
		
	}
	@Override
	public void run() {
		Product mProduct = new ProductManage(mProductId).getProduct();
		if (mProduct.getStatus()!=0) {
			cancel();
			System.gc();
		}
		session = HibernateSessionFactory.getSession();
		transaction = session.beginTransaction();
		if (lastprice - cutprice >= lowestprice) {
			lastprice -=cutprice;
			mProduct.setLastPrice(lastprice);
			session.update(mProduct);

		}
		else {
			mProduct.setLastPrice(lowestprice);
			mProduct.setStatus(1);
			session.update(mProduct);
		}
		
		transaction.commit();
		session.close();
	}

}
