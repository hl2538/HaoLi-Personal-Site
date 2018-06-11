package com.haoli.controller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.haoli.domain.Accelerometer;
import com.haoli.domain.Displacement;
import com.haoli.util.MathUtil;

import plotDisData.MatlabPlotter;

public class SocketController{
	double dx;
	double dy;
	Displacement dis;
	ServerSocket server;
	Socket socket;
	SendDataTask sendDataTask;
	InputStream inputStream;

	public static void main(String[] args) throws Exception {
		
		MathUtil mu = new MathUtil(0.1);
		File file = new File("/Users/haoli/topcoder/data.txt");
        if(!file.exists() ){
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = null;
        fileOutputStream = new FileOutputStream(file);
        
		SocketController sc = new SocketController();

		sc.server(mu,200);
		for(Displacement d : mu.getDisplacement()) {
			Map map = new HashMap();
			map.put("dx", d.getDx());
			map.put("dy", d.getDy());
			map.put("dz", d.getDz());
			String word = String.valueOf(d.getDx()) + " " 
						 +String.valueOf(d.getDy()) + " "
						 +String.valueOf(d.getDz()) + "\r\n";
	        fileOutputStream.write(word.getBytes("gbk"));
			System.out.println(map.toString());
		}
		
        fileOutputStream.flush();
        fileOutputStream.close();
        
	}
	  
	  
	  public void server(MathUtil mu, int maxCount ) throws Exception {

		    int port = 8888;
		    server = new ServerSocket(port);
		    while(true) {
		    	if(mu.getDisplacement().size() == maxCount)break;
		        System.out.println("server waiting for you");
		        socket = server.accept();
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
		        dx = dis.getDx();
		        dy = dis.getDy();
		        
//		        MatlabPlotter mp = new MatlabPlotter();
//		        mp.plotDisData(dx,dy);
		        
		        System.out.println("get message from client: " + sb);
//				socket.getOutputStream().write(dis.toString().getBytes());
//		        socket.getOutputStream().flush();
		        

		    }
	  }
	  


}
