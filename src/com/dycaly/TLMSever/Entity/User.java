package com.dycaly.TLMSever.Entity;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String username;
	private String password;
	private String token;
	private Integer authority;
	private Set userditalses = new HashSet(0);
	private Set reqaddfriendsForReqedId = new HashSet(0);
	private Set productsForSellerId = new HashSet(0);
	private Set reqaddfriendsForReqerId = new HashSet(0);
	private Set productsForBuyerId = new HashSet(0);
	private Set userfriendsForOwnedId = new HashSet(0);
	private Set recentfdsForOwnedId = new HashSet(0);
	private Set userfriendsForOwnerId = new HashSet(0);
	private Set recentfdsForOwnerId = new HashSet(0);
	private Set messagesForReceverId = new HashSet(0);
	private Set messagesForSenderId = new HashSet(0);
	private Set comments = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Integer userId, String username, String password, String token,
			Integer authority) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.token = token;
		this.authority = authority;
	}

	/** full constructor */
	public User(Integer userId, String username, String password, String token,
			Integer authority, Set userditalses, Set reqaddfriendsForReqedId,
			Set productsForSellerId, Set reqaddfriendsForReqerId,
			Set productsForBuyerId, Set userfriendsForOwnedId,
			Set recentfdsForOwnedId, Set userfriendsForOwnerId,
			Set recentfdsForOwnerId, Set messagesForReceverId,
			Set messagesForSenderId, Set comments) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.token = token;
		this.authority = authority;
		this.userditalses = userditalses;
		this.reqaddfriendsForReqedId = reqaddfriendsForReqedId;
		this.productsForSellerId = productsForSellerId;
		this.reqaddfriendsForReqerId = reqaddfriendsForReqerId;
		this.productsForBuyerId = productsForBuyerId;
		this.userfriendsForOwnedId = userfriendsForOwnedId;
		this.recentfdsForOwnedId = recentfdsForOwnedId;
		this.userfriendsForOwnerId = userfriendsForOwnerId;
		this.recentfdsForOwnerId = recentfdsForOwnerId;
		this.messagesForReceverId = messagesForReceverId;
		this.messagesForSenderId = messagesForSenderId;
		this.comments = comments;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getAuthority() {
		return this.authority;
	}

	public void setAuthority(Integer authority) {
		this.authority = authority;
	}

	public Set getUserditalses() {
		return this.userditalses;
	}

	public void setUserditalses(Set userditalses) {
		this.userditalses = userditalses;
	}

	public Set getReqaddfriendsForReqedId() {
		return this.reqaddfriendsForReqedId;
	}

	public void setReqaddfriendsForReqedId(Set reqaddfriendsForReqedId) {
		this.reqaddfriendsForReqedId = reqaddfriendsForReqedId;
	}

	public Set getProductsForSellerId() {
		return this.productsForSellerId;
	}

	public void setProductsForSellerId(Set productsForSellerId) {
		this.productsForSellerId = productsForSellerId;
	}

	public Set getReqaddfriendsForReqerId() {
		return this.reqaddfriendsForReqerId;
	}

	public void setReqaddfriendsForReqerId(Set reqaddfriendsForReqerId) {
		this.reqaddfriendsForReqerId = reqaddfriendsForReqerId;
	}

	public Set getProductsForBuyerId() {
		return this.productsForBuyerId;
	}

	public void setProductsForBuyerId(Set productsForBuyerId) {
		this.productsForBuyerId = productsForBuyerId;
	}

	public Set getUserfriendsForOwnedId() {
		return this.userfriendsForOwnedId;
	}

	public void setUserfriendsForOwnedId(Set userfriendsForOwnedId) {
		this.userfriendsForOwnedId = userfriendsForOwnedId;
	}

	public Set getRecentfdsForOwnedId() {
		return this.recentfdsForOwnedId;
	}

	public void setRecentfdsForOwnedId(Set recentfdsForOwnedId) {
		this.recentfdsForOwnedId = recentfdsForOwnedId;
	}

	public Set getUserfriendsForOwnerId() {
		return this.userfriendsForOwnerId;
	}

	public void setUserfriendsForOwnerId(Set userfriendsForOwnerId) {
		this.userfriendsForOwnerId = userfriendsForOwnerId;
	}

	public Set getRecentfdsForOwnerId() {
		return this.recentfdsForOwnerId;
	}

	public void setRecentfdsForOwnerId(Set recentfdsForOwnerId) {
		this.recentfdsForOwnerId = recentfdsForOwnerId;
	}

	public Set getMessagesForReceverId() {
		return this.messagesForReceverId;
	}

	public void setMessagesForReceverId(Set messagesForReceverId) {
		this.messagesForReceverId = messagesForReceverId;
	}

	public Set getMessagesForSenderId() {
		return this.messagesForSenderId;
	}

	public void setMessagesForSenderId(Set messagesForSenderId) {
		this.messagesForSenderId = messagesForSenderId;
	}

	public Set getComments() {
		return this.comments;
	}

	public void setComments(Set comments) {
		this.comments = comments;
	}

}