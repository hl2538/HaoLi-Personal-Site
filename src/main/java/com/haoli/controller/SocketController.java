package com.haoli.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.alibaba.fastjson.JSONObject;
import com.haoli.domain.Accelerometer;
import com.haoli.domain.Displacement;
import com.haoli.util.MathUtil;
import com.mathworks.toolbox.javabuilder.MWException;

import plotDis.Plotter;

public class SocketController {
	
	public static void main(String[] args) throws IOException, MWException {
		MathUtil mu = new MathUtil(0.1);
		File file = new File("C:\\Users\\10063731\\Desktop\\data.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = null;
        fileOutputStream = new FileOutputStream(file);
        
		SocketController sc = new SocketController();
		sc.server(mu);
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
	  
	  public void client() throws UnsupportedEncodingException, IOException {
		    // 要连接的服务端IP地址和端口
		    String host = "10.1.144.12"; 
		    int port = 8888;
		    // 与服务端建立连接
		    Socket socket = new Socket(host, port);
		    // 建立连接后获得输出流
		    OutputStream outputStream = socket.getOutputStream();
		    String message="你好  yiwangzhibujian";
		    socket.getOutputStream().write(message.getBytes("UTF-8"));
		    outputStream.close();
		    socket.close();
	  }
	  
	  public void server(MathUtil mu) throws IOException, MWException {

		    // 监听指定的端口
		    int port = 8888;
		    ServerSocket server = new ServerSocket(port);
		    while(true) {
		    	if(mu.getDisplacement().size() == 200)break;
		        System.out.println("server将一直等待连接的到来");
		        Socket socket = server.accept();
		        
		        // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
		        InputStream inputStream = socket.getInputStream();
		        byte[] bytes = new byte[1024];
		        int len;
		        StringBuilder sb = new StringBuilder();
		        while ((len = inputStream.read(bytes)) != -1) {
		          //注意指定编码格式，发送方和接收方一定要统一，建议使用UTF-8
		          sb.append(new String(bytes, 0, len,"UTF-8"));
		        }
		        System.out.println("get message from client: " + sb);
		        JSONObject jobj = (JSONObject)JSONObject.parse(sb.toString());
		        Accelerometer accel = new Accelerometer();
		        
		        accel.setAx(jobj.getDoubleValue("ax"));
		        accel.setAy(jobj.getDoubleValue("ay"));
		        accel.setAz(jobj.getDoubleValue("az"));
		        mu.computeVelocity(accel);
		        Displacement dis = mu.computeDisplacement(accel);
		        
		        double dx = dis.getDx();
		        double dy = dis.getDy();
		        double dz = dis.getDz();
		        
		        Plotter plotter = new Plotter();
		        plotter.plotDis(dx, dy);
		        
		        socket.getOutputStream().write(dis.toString().getBytes());
		        socket.getOutputStream().flush();
		        List list = mu.getDisplacement();
		        System.out.println("get message from client: " + sb);
		        
//		        inputStream.close();
//		        socket.close();
//		        server.close();
		    }
	  }
}
