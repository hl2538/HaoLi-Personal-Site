package com.haoli.controller;

import java.io.IOException;
import java.net.Socket;

import com.haoli.domain.Displacement;

public class SendDataTask implements Runnable{

	Socket socket;
	Displacement dis;
	
	public SendDataTask(Socket socket){
		this.socket = socket;
	}
	
	
	  @Override
	  public void run(){
	        try {
				socket.getOutputStream().write(dis.toString().getBytes());
		        socket.getOutputStream().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
	  }
}
