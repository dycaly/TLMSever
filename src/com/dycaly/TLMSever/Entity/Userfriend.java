package com.dycaly.TLMSever.Entity;

/**
 * Userfriend entity. @author MyEclipse Persistence Tools
 */

public class Userfriend implements java.io.Serializable {

	// Fields

	private Integer userfriend;
	private User userByOwnerId;
	private User userByOwnedId;

	// Constructors

	/** default constructor */
	public Userfriend() {
	}

	/** full constructor */
	public Userfriend(Integer userfriend, User userByOwnerId, User userByOwnedId) {
		this.userfriend = userfriend;
		this.userByOwnerId = userByOwnerId;
		this.userByOwnedId = userByOwnedId;
	}

	// Property accessors

	public Integer getUserfriend() {
		return this.userfriend;
	}

	public void setUserfriend(Integer userfriend) {
		this.userfriend = userfriend;
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