package com.boe.middleware.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.haoli.domain.JsonResponse;
import com.haoli.domain.OaApprovalRequest;


@WebService(name = "WebServiceFromOa",
targetNamespace = "http://webservice.middleware.boe.com")// 命名空间,一般是接口的包名倒序
@Component
public interface WebServiceFromOa {
    @WebMethod
    public JsonResponse<String> sendOaApprovalRequest(@WebParam(name="oaApprovalRequest") OaApprovalRequest request)throws Exception;
}
