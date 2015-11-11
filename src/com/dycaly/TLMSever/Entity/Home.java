package com.dycaly.TLMSever.Entity;

/**
 * Home entity. @author MyEclipse Persistence Tools
 */

public class Home implements java.io.Serializable {

	// Fields

	private Integer homeId;
	private Product product;
	private Integer which;

	// Constructors

	/** default constructor */
	public Home() {
	}

	/** full constructor */
	public Home(Integer homeId, Product product, Integer which) {
		this.homeId = homeId;
		this.product = product;
		this.which = which;
	}

	// Property accessors

	public Integer getHomeId() {
		return this.homeId;
	}

	public void setHomeId(Integer homeId) {
		this.homeId = homeId;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getWhich() {
		return this.which;
	}

	public void setWhich(Integer which) {
		this.which = which;
	}

}