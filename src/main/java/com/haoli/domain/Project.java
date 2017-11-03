package com.haoli.domain;


public class Project {
	
	private String name;
	
	private String description;
	
	private Long id;
	
	private String createTime;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}