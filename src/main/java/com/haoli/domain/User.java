package com.haoli.domain;

public class User {
	
	private int id;
	private String loginName;
	private String password;
	private String nickName;
	private String email;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	public String getLoginName() {
		return this.loginName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassWord() {
		return this.password;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getNickName() {
		return this.nickName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}

}
