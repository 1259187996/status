package com.im.status.base.cache;

import java.io.Serializable;
import java.util.Map;

public class MyRedisKeyExpiredMessageDelegate implements MyMessageDelegate {

	public void handleMessage(String message) {
		// TODO Auto-generated method stub
		System.out.println("====================message1:"+message);
	}

	public void handleMessage(Map message) {
		// TODO Auto-generated method stub
		System.out.println("====================message2:"+message);

	}

	public void handleMessage(byte[] message) {
		// TODO Auto-generated method stub
		System.out.println("====================message3:"+message);

	}

	public void handleMessage(Serializable message) {
		// TODO Auto-generated method stub
		System.out.println("====================message4:"+message);

	}

	public void handleMessage(Serializable message, String channel) {
		// TODO Auto-generated method stub
		System.out.println("====================message:"+message+"===================channel:"+channel);
	}
  // implementation elided for clarity...
}
