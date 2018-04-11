package com.haoli.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class OaResponse {
	protected String message;
	protected String name;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
