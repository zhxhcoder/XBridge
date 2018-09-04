package com.zhxh.xbridge;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zhxh on 2018/9/4
 */
public class ParcelData implements Parcelable {
    private int data1;
    private int data2;

    public ParcelData() {

    }

    protected ParcelData(Parcel in) {
        readFromParcel(in);
    }

    public static final Creator<ParcelData> CREATOR = new Creator<ParcelData>() {
        @Override
        public ParcelData createFromParcel(Parcel in) {
            return new ParcelData(in);
        }

        @Override
        public ParcelData[] newArray(int size) {
            return new ParcelData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * 将数据写入到Parcel
     **/
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(data1);
        dest.writeInt(data2);
    }

    /**
     * 从Parcel中读取数据
     **/
    public void readFromParcel(Parcel in) {
        data1 = in.readInt();
        data2 = in.readInt();
    }


    public int getData2() {
        return data2;
    }

    public void setData2(int data2) {
        this.data2 = data2;
    }

    public int getData1() {
        return data1;
    }

    public void setData1(int data1) {
        this.data1 = data1;
    }

    @Override
    public String toString() {
        return "data1 = " + data1 + ", data2=" + data2;
    }
}
