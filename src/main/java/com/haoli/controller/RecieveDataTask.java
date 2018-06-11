package com.haoli.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import com.alibaba.fastjson.JSONObject;
import com.haoli.domain.Accelerometer;
import com.haoli.domain.Displacement;
import com.haoli.util.MathUtil;

public class RecieveDataTask implements Runnable{

	Socket socket;
	MathUtil mu;
	Displacement dis;
	
	public RecieveDataTask(Socket socket, MathUtil mu, Displacement dis){
		this.socket = socket;
		this.mu = mu;
		this.dis = dis;
	}
	
	@Override
	public void run(){
		InputStream inputStream;
		try {
			inputStream = socket.getInputStream();
	        byte[] bytes = new byte[1024];
	        int len;
	        StringBuilder sb = new StringBuilder();
	        while ((len = inputStream.read(bytes)) != -1) {
	          sb.append(new String(bytes, 0, len,"UTF-8"));
	        }
	        System.out.println("get message from client: " + sb);
	        JSONObject jobj = (JSONObject)JSONObject.parse(sb.toString());
	        Accelerometer accel = new Accelerometer();
	        
	        accel.setAx(jobj.getDoubleValue("ax"));
	        accel.setAy(jobj.getDoubleValue("ay"));
	        accel.setAz(jobj.getDoubleValue("az"));
	        mu.computeVelocity(accel);
	        dis = mu.computeDisplacement(accel);
	        
	        System.out.println("get message from client: " + sb);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
