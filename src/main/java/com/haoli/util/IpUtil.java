package com.haoli.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpUtil {
	
	public static void main(String[] args) {
		System.out.println(IpUtil.getLocalIp());
	}
	
	/**
	 * getLocalIp:获取当前机器的IP
	 *
	 */
	public static String getLocalIp(){
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
