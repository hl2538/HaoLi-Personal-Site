package com.haoli.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.haoli.domain.OaResponse;

@WebService(name="OaWebService")
@SOAPBinding(style=Style.RPC,use=Use.LITERAL)
public interface OaWebService {
	
	@WebMethod(operationName="getOaResponse")
	@RequestWrapper(className="java.lang.String")
	@ResponseWrapper(className="com.haoli.domain.OaResponse")
	public OaResponse getOaResponse(
		@WebParam(name="name", mode=Mode.IN)
		String name
	);
}
