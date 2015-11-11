package com.dycaly.TLMSever.Entity;

/**
 * Recentfd entity. @author MyEclipse Persistence Tools
 */

public class Recentfd implements java.io.Serializable {

	// Fields

	private Integer recentfdId;
	private User userByOwnerId;
	private User userByOwnedId;

	// Constructors

	/** default constructor */
	public Recentfd() {
	}

	/** full constructor */
	public Recentfd(Integer recentfdId, User userByOwnerId, User userByOwnedId) {
		this.recentfdId = recentfdId;
		this.userByOwnerId = userByOwnerId;
		this.userByOwnedId = userByOwnedId;
	}

	// Property accessors

	public Integer getRecentfdId() {
		return this.recentfdId;
	}

	public void setRecentfdId(Integer recentfdId) {
		this.recentfdId = recentfdId;
	}

	public User getUserByOwnerId() {
		return this.userByOwnerId;
	}

	public void setUserByOwnerId(User userByOwnerId) {
		this.userByOwnerId = userByOwnerId;
	}

	public User getUserByOwnedId() {
		return this.userByOwnedId;
	}

	public void setUserByOwnedId(User userByOwnedId) {
		this.userByOwnedId = userByOwnedId;
	}

}