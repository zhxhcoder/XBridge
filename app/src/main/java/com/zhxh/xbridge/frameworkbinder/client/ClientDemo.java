package com.zhxh.xbridge.frameworkbinder.client;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;

public class ClientDemo {
 
	public static void main(String[] args) throws RemoteException {
		System.out.println("Client start");
		IBinder binder = ServiceManager.getService("MyService"); //��ȡ��Ϊ"MyService"�ķ���
		IMyService myService = new MyServiceProxy(binder); //����MyServiceProxy����
		myService.sayHello("binder"); //ͨ��MyServiceProxy������ýӿڵķ���
		System.out.println("Client end");
	}
}
