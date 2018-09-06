package com.zhxh.xbridge.frameworkbinder.server;

import android.os.Looper;
import android.os.ServiceManager;

public class ServerDemo {

	public static void main(String[] args) {
		System.out.println("MyService Start");
		Looper.prepareMainLooper(); //����ѭ��ִ��
		android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_FOREGROUND);
		ServiceManager.addService("MyService", new MyService());
		Looper.loop();
	}

}
