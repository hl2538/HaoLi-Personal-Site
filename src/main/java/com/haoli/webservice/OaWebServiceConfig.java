package com.haoli.webservice;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.boe.middleware.webservice.OaWebService;

@Configuration
public class OaWebServiceConfig {
    @Autowired
    private Bus bus;

    @Autowired
    private OaWebService oaWebServices;

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus,oaWebServices);
        endpoint.publish("/OaWebService");//接口发布在 /OaWebService 目录下
        return endpoint;
    }	
    
}
