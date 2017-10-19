package com.haoli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

@EnableConfigurationProperties
@SpringBootApplication
public class haoliPersonalApp {
	public static void main(String[] args) {
		ApplicationContext app = SpringApplication.run(haoliPersonalApp.class, args);
	}
}
