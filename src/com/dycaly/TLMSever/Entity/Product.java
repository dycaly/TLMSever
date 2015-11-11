package com.dycaly.TLMSever.Entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	// Fields

	private Integer productId;
	private User userByBuyerId;
	private Classify classify;
	private User userBySellerId;
	private String productUrl;
	private String productName;
	private String productIntro;
	private Integer hightestPrice;
	private Integer lowestPrice;
	private Integer cutPrice;
	private Integer cutTime;
	private Integer status;
	private Timestamp sellDate;
	private Integer lastPrice;
	private Set homes = new HashSet(0);
	private Set comments = new HashSet(0);

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
	public Product(User userByBuyerId,Classify classify, User userBySellerId, String productUrl,
			String productName, String productIntro, Integer hightestPrice,
			Integer lowestPrice, Integer cutPrice, Integer cutTime,
			Integer status, Timestamp sellDate, int lastprice) {
		this.userByBuyerId =userByBuyerId;
		this.classify = classify;
		this.userBySellerId = userBySellerId;
		this.productUrl = productUrl;
		this.productName = productName;
		this.productIntro = productIntro;
		this.hightestPrice = hightestPrice;
		this.lowestPrice = lowestPrice;
		this.cutPrice = cutPrice;
		this.cutTime = cutTime;
		this.status = status;
		this.sellDate = sellDate;
		this.lastPrice =lastPrice;
	}

	/** full constructor */
	public Product(User userByBuyerId, Classify classify, User userBySellerId,
			String productUrl, String productName, String productIntro,
			Integer hightestPrice, Integer lowestPrice, Integer cutPrice,
			Integer cutTime, Integer status, Timestamp sellDate,
			Integer lastPrice, Set homes, Set comments) {
		this.userByBuyerId = userByBuyerId;
		this.classify = classify;
		this.userBySellerId = userBySellerId;
		this.productUrl = productUrl;
		this.productName = productName;
		this.productIntro = productIntro;
		this.hightestPrice = hightestPrice;
		this.lowestPrice = lowestPrice;
		this.cutPrice = cutPrice;
		this.cutTime = cutTime;
		this.status = status;
		this.sellDate = sellDate;
		this.lastPrice = lastPrice;
		this.homes = homes;
		this.comments = comments;
	}

	// Property accessors

	public Integer getProductId() {
		return this.productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public User getUserByBuyerId() {
		return this.userByBuyerId;
	}

	public void setUserByBuyerId(User userByBuyerId) {
		this.userByBuyerId = userByBuyerId;
	}

	public Classify getClassify() {
		return this.classify;
	}

	public void setClassify(Classify classify) {
		this.classify = classify;
	}

	public User getUserBySellerId() {
		return this.userBySellerId;
	}

	public void setUserBySellerId(User userBySellerId) {
		this.userBySellerId = userBySellerId;
	}

	public String getProductUrl() {
		return this.productUrl;
	}

	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductIntro() {
		return this.productIntro;
	}

	public void setProductIntro(String productIntro) {
		this.productIntro = productIntro;
	}

	public Integer getHightestPrice() {
		return this.hightestPrice;
	}

	public void setHightestPrice(Integer hightestPrice) {
		this.hightestPrice = hightestPrice;
	}

	public Integer getLowestPrice() {
		return this.lowestPrice;
	}

	public void setLowestPrice(Integer lowestPrice) {
		this.lowestPrice = lowestPrice;
	}

	public Integer getCutPrice() {
		return this.cutPrice;
	}

	public void setCutPrice(Integer cutPrice) {
		this.cutPrice = cutPrice;
	}

	public Integer getCutTime() {
		return this.cutTime;
	}

	public void setCutTime(Integer cutTime) {
		this.cutTime = cutTime;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getSellDate() {
		return this.sellDate;
	}

	public void setSellDate(Timestamp sellDate) {
		this.sellDate = sellDate;
	}

	public Integer getLastPrice() {
		return this.lastPrice;
	}

	public void setLastPrice(Integer lastPrice) {
		this.lastPrice = lastPrice;
	}

	public Set getHomes() {
		return this.homes;
	}

	public void setHomes(Set homes) {
		this.homes = homes;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

}