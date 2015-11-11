package com.dycaly.TLMSever.Entity;

import java.sql.Timestamp;

/**
 * Userditals entity. @author MyEclipse Persistence Tools
 */

public class Userditals implements java.io.Serializable {

	// Fields

	private Integer userId;
	private User user;
	private String picUrl;
	private String nickname;
	private String name;
	private Integer age;
	private Integer sex;
	private String school;
	private String college;
	private String email;
	private String phone;
	private Timestamp regdate;

	// Constructors

	/** default constructor */
	public Userditals() {
	}

	/** minimal constructor */
	public Userditals(Integer userId, User user, Timestamp regdate) {
		this.userId = userId;
		this.user = user;
		this.regdate = regdate;
	}

	/** full constructor */
	public Userditals(Integer userId, User user, String picUrl,
			String nickname, String name, Integer age, Integer sex,
			String school, String college, String email, String phone,
			Timestamp regdate) {
		this.userId = userId;
		this.user = user;
		this.picUrl = picUrl;
		this.nickname = nickname;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.school = school;
		this.college = college;
		this.email = email;
		this.phone = phone;
		this.regdate = regdate;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getCollege() {
		return this.college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Timestamp getRegdate() {
		return this.regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

}