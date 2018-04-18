package com.haoli.domain;

public class TrainingInfo {
	
	//培训名称
	private String name;
	
	//课程在学校平台上的链接
	private String url;
	
	//培训描述
	private String training_desc;
	
	//培训类型
	private String type;
	
	//course表示课程，project表示项目
	private String object_type;
	
	//true为必修，false为选修
	private String is_obligated;
	
	//培训时长
	private String duration;
	
	//培训等级
	private String level;
	
	//培训费用
	private String price;
	
	//费用承担组织
	private String paid_by;
	
	//报名开始时间
	private String enroll_time_start;
	
	//报名结束时间
	private String enroll_time_end;
	
	//培训开始时间
	private String training_time_start;
	
	//培训结束时间
	private String training_time_end;
	
	//培训地点
	private String location;
	
	//课程对应的学分
	private String score;
	
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return this.url;
	}
	
	public void setTrainingDesc(String training_desc) {
		this.training_desc = training_desc;
	}
	
	public String getTrainingDesc() {
		return this.training_desc;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setObjectType(String object_type) {
		this.object_type = object_type;
	}
	
	public String getObjectType() {
		return this.object_type;
	}
	
	public void setIsObligated(String is_obligated) {
		this.is_obligated = is_obligated;
	}
	
	public String getIsObligated() {
		return this.is_obligated;
	}
	
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	public String getDuration() {
		return this.duration;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}
	
	public String getLevel() {
		return this.level;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getPrice() {
		return this.price;
	}
	
	public void setPaidBy(String paid_by) {
		this.paid_by = paid_by;
	}
	
	public String getPaidBy() {
		return this.paid_by;
	}
	
	public void setEnrollTimeStart(String enroll_time_start) {
		this.enroll_time_start = enroll_time_start;
	}
	
	public String getEnrollTimeStart() {
		return this.enroll_time_start;
	}
	
	public void setEnrollTimeEnd(String enroll_time_end) {
		this.enroll_time_end = enroll_time_end;
	}
	
	public String getEnrollTimeEnd() {
		return this.enroll_time_end;
	}
	
	public void setTrainingTimeStart(String training_time_start) {
		this.training_time_start = training_time_start;
	}
	
	public String getTrainingTimeStart() {
		return this.training_time_start;
	}
	
	public void setTrainingTimeEnd(String training_time_end) {
		this.training_time_end = training_time_end;
	}
	
	public String getTrainingTimeEnd() {
		return this.training_time_end;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public void setScore(String score) {
		this.score = score;
	}
	
	public String getScore() {
		return this.score;
	}
	
	
}
