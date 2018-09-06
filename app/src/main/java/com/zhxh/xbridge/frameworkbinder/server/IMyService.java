package com.zhxh.xbridge.frameworkbinder.server;

import android.os.IInterface;
import android.os.RemoteException;

public interface IMyService extends IInterface {
	static final String DESCRIPTOR = "com.zhxh.xbridge.frameworkbinder.MyServer";
	public void sayHello(String str) throws RemoteException ;
    static final int TRANSACTION_say = android.os.IBinder.FIRST_CALL_TRANSACTION;
}
