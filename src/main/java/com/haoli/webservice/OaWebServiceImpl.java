package com.haoli.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSONObject;



@WebService(serviceName = "OaWebService",//服务名
			targetNamespace = "http://webservice.middleware.boe.com",//报名倒叙，并且和接口定义保持一致
			endpointInterface = "com.boe.middleware.webservice.OaWebService")//包名
@Component
public class OaWebServiceImpl implements OaWebService{
	

   @Override
   public String getOaApprovalResponse()  {
	   return "success";
   }
   
	
}
