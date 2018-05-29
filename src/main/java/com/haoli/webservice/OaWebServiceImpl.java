package com.haoli.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.alibaba.fastjson.JSONObject;
import com.boe.middleware.domain.JsonResponse;
import com.boe.middleware.domain.OaApprovalRequest;
import com.boe.middleware.domain.OaApprovalResponse;
import com.boe.middleware.util.HTTPUtil;
import com.boe.middleware.util.JsonUtil;
import com.boe.middleware.webservice.OaWebService;


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
