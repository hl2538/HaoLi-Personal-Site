package com.haoli.domain;

public class JsonResponse<T> {

	private String code;
	
	private String msg;
	
	private T data;
	
	public JsonResponse(){
		
	}
	
	public JsonResponse(T data){
		this.code = "0";
		this.msg = "成功";
		this.data = data;
	}
	
	public JsonResponse(String code, String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public boolean isSuccess(){
		return "0".equals(this.code);
	}
	
	public static JsonResponse<String> success(){
		return new JsonResponse<String>(null);
	}
	
	public static JsonResponse<String> success(String data){
		return new JsonResponse<String>(data);
	}
	
	public static JsonResponse<String> fail(){
		return new JsonResponse<String>("1", "fail");
	}
	
	public static JsonResponse<String> fail(String msg){
		return new JsonResponse<String>("1", msg);
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