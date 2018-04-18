package com.haoli.domain;

import java.util.List;

public class OaApprovalRequest {
	
	//系统自分配id，不需要oa传
	private Long id;
	
	//申请人工号
	private String user_no;

	//BOEU的培训申请
	private String request_type;

	//审批申请识别id
	private String request_id;
	
	//审批名称
	private String request_name;
	
	//培训信息
	private TrainingInfo training_info;
	
	//办结知会
	private List<String> inform;
	
	//默认知会
	private List<String> default_inform;
	
	//附件
	private List<String> attachment;
	
	//请求时间戳
	private String time;
	
	
	public Long getId() {
		return this.id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUserNo() {
		return this.user_no;
	}
	
	public void setUserNo(String user_no) {
		this.user_no = user_no;
	}
	
	public String getRequestType() {
		return this.request_type;
	}
	
	public void setRequestType(String request_type) {
		this.request_type = request_type;
	}
	
	public String getRequestId() {
		return this.request_id;
	}
	
	public void setRequestId(String request_id) {
		this.request_id = request_id;
	}
	
	public String getRequestName() {
		return this.request_name;
	}
	
	public void setRequestName(String request_name) {
		this.request_name = request_name;
	}
	
	public TrainingInfo getTrainingInfo() {
		return this.training_info;
	}
	
	public void setTrainingInfo(TrainingInfo training_info) {
		this.training_info = training_info;
	}
	
	public List<String> getInform() {
		return this.inform;
	}
	
	public void setInform(List<String> inform) {
		this.inform = inform;
	}
	
	public List<String> getDefaultInform() {
		return this.default_inform;
	}
	
	public void setDefaultInform(List<String> default_inform) {
		this.default_inform = default_inform;
	}
	
	public List<String> getAttachment() {
		return this.attachment;
	}
	
	public void setAttachment(List<String> attachment) {
		this.attachment = attachment;
	}
	
	public String getTime() {
		return this.time;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
