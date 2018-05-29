package com.haoli.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketController {
	  
	  public void client() throws UnsupportedEncodingException, IOException {
		    // 要连接的服务端IP地址和端口
		    String host = "10.1.144.12"; 
		    int port = 8080;
		    // 与服务端建立连接
		    Socket socket = new Socket(host, port);
		    // 建立连接后获得输出流
		    OutputStream outputStream = socket.getOutputStream();
		    String message="你好  yiwangzhibujian";
		    socket.getOutputStream().write(message.getBytes("UTF-8"));
		    outputStream.close();
		    socket.close();
	  }
	  
	  public void server() throws IOException {
		    // 监听指定的端口
		    int port = 8080;
		    ServerSocket server = new ServerSocket(port);
		    
		    while(true) {
		    	
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
		        
//		        inputStream.close();
//		        socket.close();
//		        server.close();
		    }
	  }
}
