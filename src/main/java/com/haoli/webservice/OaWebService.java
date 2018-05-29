package com.haoli.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.boe.middleware.domain.JsonResponse;
import com.boe.middleware.domain.OaApprovalRequest;
import com.boe.middleware.domain.OaApprovalResponse;

@WebService
public interface OaWebService {
    
    @WebMethod
    public String getOaApprovalResponse();
    
    	
}
