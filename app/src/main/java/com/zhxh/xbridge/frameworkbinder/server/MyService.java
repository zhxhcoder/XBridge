package com.zhxh.xbridge.frameworkbinder.server;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public class MyService extends Binder implements IMyService{ 
	

	public MyService() {
		this.attachInterface(this, DESCRIPTOR);
	}

	@Override
	public IBinder asBinder() {
		return this;
	}

	public static com.zhxh.xbridge.frameworkbinder.server.IMyService asInterface(
			IBinder obj) {
		if ((obj == null)) {
			return null;
		}
		android.os.IInterface iInterface = obj.queryLocalInterface(DESCRIPTOR);
		if (((iInterface != null) && (iInterface instanceof com.zhxh.xbridge.frameworkbinder.server.IMyService))) {
			return ((com.zhxh.xbridge.frameworkbinder.server.IMyService) iInterface);
		}
		return null;
	}

	@Override
	protected boolean onTransact(int code, Parcel data, Parcel reply, int flags)
			throws RemoteException {
		switch (code) {
		case INTERFACE_TRANSACTION: {
			reply.writeString(DESCRIPTOR);
			return true;
		}
		case TRANSACTION_say: {
			data.enforceInterface(DESCRIPTOR);
			String str = data.readString();
			sayHello(str);
			reply.writeNoException();
			return true;
		}
		}
		return super.onTransact(code, data, reply, flags);
	}

	@Override
	public void sayHello(String str) {
		System.out.println("MyService:: Hello, " + str);
	}


}
