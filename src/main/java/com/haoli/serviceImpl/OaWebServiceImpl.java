package com.haoli.serviceImpl;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import com.haoli.domain.OaResponse;
import com.haoli.service.OaWebService;


@WebService(endpointInterface="com.haoli.service.OaWebService",
			serviceName="OaWebService")
public class OaWebServiceImpl implements OaWebService{
	
	public static void main(String[] args) throws Exception {
		String ip = InetAddress.getLocalHost().getHostAddress();
		System.out.println(ip);
		Endpoint.publish("http://"+ip+":8088/OaWebService", new OaWebServiceImpl());
	}
	
	
	
	
	@Override
	public OaResponse getOaResponse(String name) {
		OaResponse response = new OaResponse();
		response.setMessage("Hello");
		response.setName(name);
		return response;
	}
}
