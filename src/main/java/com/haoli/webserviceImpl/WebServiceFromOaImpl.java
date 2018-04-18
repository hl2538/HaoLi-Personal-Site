package com.haoli.webserviceImpl;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.haoli.domain.JsonResponse;
import com.haoli.domain.OaApprovalRequest;
import com.haoli.webservice.WebServiceFromOa;


@WebService(serviceName = "WebServiceFromOae",//服务名
targetNamespace = "http://webservice.middleware.boe.com",//报名倒叙，并且和接口定义保持一致
endpointInterface = "com.boe.middleware.webservice.WebServiceFromOa")//包名
@Component
public class WebServiceFromOaImpl implements WebServiceFromOa{
	   /**
	    * 发送学员报名信息给oa
	    * @throws Exception 
	    */
	   @Override
	   public JsonResponse<String> sendOaApprovalRequest(@WebParam(name="oaApprovalRequest") OaApprovalRequest request) throws Exception {
		   return new JsonResponse<String>("0", "recieved data success");
	   }
}
