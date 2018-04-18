package com.haoli.domain;


public class JsonResponse<T> {

	private String code;
	
	private String msg;
	
	private T data;
	
	public JsonResponse(){
		
	}
	
	public JsonResponse(T data,String code,String msg){
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	
	public JsonResponse(String code, String msg){
		this.code = code;
		this.msg = msg;
	}
	
	
	public boolean isSuccess(){
		return "0".equals(this.code);
	}
	
	public static JsonResponse<String> success(String code, String msg){
		return new JsonResponse<String>(code, msg);
	}
	

	public static JsonResponse<String> fail(String code, String msg){
		return new JsonResponse<String>(code, msg);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}