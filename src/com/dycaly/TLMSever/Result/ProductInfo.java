package com.dycaly.TLMSever.Result;

public class ProductInfo {

	private int productid;
	private String producturl;
	private String productname;
	private String productintro;
	private int hightestprice;
	private int lowestprice;
	private int cuttime;
	private int cutprice;
	private int status;
	private String sellername;
	private String sellernickname;
	private String selldate;
	private String buyername;
	private int lastprice;
	private String classify;
	public ProductInfo(int productid,String producturl, String productname,String sellernickname,
			String productintro, int hightestprice, int lowestprice,
			int cuttime, int cutprice,int status, String sellername, String selldate,
			String buyername, int lastprice, String classify) {

		this.productid = productid;
		this.producturl = producturl;
		this.productname = productname;
		this.productintro = productintro;
		this.hightestprice = hightestprice;
		this.lowestprice = lowestprice;
		this.cuttime = cuttime;
		this.cutprice =cutprice;
		this.status = status;
		this.sellername = sellername;
		this.sellernickname = sellernickname;
		this.selldate = selldate;
		this.buyername = buyername;
		this.lastprice = lastprice;
		this.classify = classify;
	}
	
}
