package com.dycaly.TLMSever.Entity;

import java.sql.Timestamp;

/**
 * Reqaddfriend entity. @author MyEclipse Persistence Tools
 */

public class Reqaddfriend implements java.io.Serializable {

	// Fields

	private Integer reqaddfriendId;
	private User userByReqedId;
	private User userByReqerId;
	private Timestamp reqtime;
	private Integer issaw;

	// Constructors

	/** default constructor */
	public Reqaddfriend() {
	}

	/** full constructor */
	public Reqaddfriend(User userByReqedId, User userByReqerId,
			Timestamp reqtime, Integer issaw) {
		this.userByReqedId = userByReqedId;
		this.userByReqerId = userByReqerId;
		this.reqtime = reqtime;
		this.issaw = issaw;
	}

	// Property accessors

	public Integer getReqaddfriendId() {
		return this.reqaddfriendId;
	}

	public void setReqaddfriendId(Integer reqaddfriendId) {
		this.reqaddfriendId = reqaddfriendId;
	}

	public User getUserByReqedId() {
		return this.userByReqedId;
	}

	public void setUserByReqedId(User userByReqedId) {
		this.userByReqedId = userByReqedId;
	}

	public User getUserByReqerId() {
		return this.userByReqerId;
	}

	public void setUserByReqerId(User userByReqerId) {
		this.userByReqerId = userByReqerId;
	}

	public Timestamp getReqtime() {
		return this.reqtime;
	}

	public void setReqtime(Timestamp reqtime) {
		this.reqtime = reqtime;
	}

	public Integer getIssaw() {
		return this.issaw;
	}

	public void setIssaw(Integer issaw) {
		this.issaw = issaw;
	}

}