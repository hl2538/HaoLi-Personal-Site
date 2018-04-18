package com.haoli.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.boe.middleware.webservice.WebServiceFromOa;

@Configuration
public class OaWebServiceConfig {
    @Autowired
    private Bus bus;
    
    @Autowired
    private WebServiceFromOa webServiceFromOa;

    @Bean
    public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus,webServiceFromOa);
        endpoint.publish("/WebServiceFromOa");//接口发布在 /WebServiceFromOa 目录下
        return endpoint;
    }	
    
}
