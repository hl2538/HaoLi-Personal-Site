package com.haoli.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.stereotype.Component;



@WebService
public interface OaWebService {
    
    @WebMethod
    public String getOaApprovalResponse();
    
    	
}
