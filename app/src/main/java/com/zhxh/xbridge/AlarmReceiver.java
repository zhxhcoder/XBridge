package com.zhxh.xbridge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by zhxh on 2018/9/4
 */
public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "你设置的闹钟时间到了", Toast.LENGTH_LONG).show();
    }
}