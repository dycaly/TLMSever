package com.dycaly.TLMSever.Result;

import java.util.ArrayList;

public class ProductResult {

	private int status;
	private ArrayList<ProductInfo> productInfos;
	
	
	public ProductResult(int status) {
		this.status = status;
		productInfos = new ArrayList<ProductInfo>();
	}
	
	public void addProductInfo(ProductInfo pi){
		productInfos.add(pi);
	}
	
}
