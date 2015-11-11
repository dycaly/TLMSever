package com.dycaly.TLMSever.Result;


public class UserDitalsResult {

	private int status;
	private String picUrl;
	private String nickname;
	private String name;
	private int age;
	private int sex;
	private String school;
	private String college;
	private String email;
	private String phone;
	private String regdate;
	public UserDitalsResult(int status, String picUrl, String nickname,
			String name, int age, int sex, String school, String college,
			String email, String phone, String regdate) {
		this.status = status;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	
	
}
