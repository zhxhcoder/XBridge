package com.zhxh.xbridge;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by zhxh on 2018/9/4
 */
public class AlarmSetActivity extends AppCompatActivity {

    Button mButton1;
    Button mButton2;

    TextView mTextView;

    Calendar calendar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_alarm_set);
        /* 实例模式 */
        calendar = Calendar.getInstance();

        mTextView = findViewById(R.id.text);
        mButton1 = findViewById(R.id.set);
        mButton2 = findViewById(R.id.cancle);

        mButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //获取当前时间
                calendar.setTimeInMillis(System.currentTimeMillis());

                int mHour = calendar.get(Calendar.HOUR_OF_DAY);
                int mMinute = calendar.get(Calendar.MINUTE);

                new TimePickerDialog(AlarmSetActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                calendar.setTimeInMillis(System.currentTimeMillis());
                                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                                calendar.set(Calendar.MINUTE, minute);
                                calendar.set(Calendar.SECOND, 0);
                                calendar.set(Calendar.MILLISECOND, 0);

                                /* 建立Intent和PendingIntent，来调用目标组件 */
                                Intent intent = new Intent(AlarmSetActivity.this, AlarmReceiver.class);
                                /*从系统取得一个用于向BroadcastReceiver的Intent广播的PendingIntent对象*/
                                PendingIntent pendingIntent = PendingIntent.
                                        getBroadcast(AlarmSetActivity.this, 0, intent, 0);

                                AlarmManager am;
                                /* 获取闹钟管理的实例 */
                                am = (AlarmManager) getSystemService(ALARM_SERVICE);
                                /* 设置闹钟 */
                                am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
                                /* 设置周期闹 */
                                am.setRepeating(AlarmManager.RTC_WAKEUP,
                                        System.currentTimeMillis() +
                                                (10 * 1000), (24 * 60 * 60 * 1000), pendingIntent);
                                String tmpS = "设置闹钟时间为" + format(hourOfDay) + ":" + format(minute);
                                mTextView.setText(tmpS);
                            }
                        }, mHour, mMinute, true).show();
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(AlarmSetActivity.this, AlarmReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(AlarmSetActivity.this, 0, intent, 0);
                AlarmManager am;
                /* 获取闹钟管理的实例 */
                am = (AlarmManager) getSystemService(ALARM_SERVICE);
                /* 取消 */
                am.cancel(pendingIntent);
                mTextView.setText("闹钟已取消！");
            }
        });
    }

    /* 格式化字符串(7:3->07:03) */
    private String format(int x) {
        String s = "" + x;
        if (s.length() == 1)
            s = "0" + s;
        return s;
    }
}
