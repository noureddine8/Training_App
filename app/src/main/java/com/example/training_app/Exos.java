package com.example.training_app;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;

public class Exos implements Parcelable {
    private int id;
    private String title;
    private String[] mainMuscle;
    private String[]  secondaryMuscle;
    private String desc;
    private String imgUrl;

    public Exos(int id, String title, String[]  mainMuscle, String[]  secondaryMuscle, String desc, String imgUrl) {
        this.id = id;
        this.title = title;
        this.mainMuscle = mainMuscle;
        this.secondaryMuscle = secondaryMuscle;
        this.desc = desc;
        this.imgUrl = imgUrl;
    }

    protected Exos(Parcel in) {
        id = in.readInt();
        title = in.readString();
        mainMuscle = in.createStringArray();
        secondaryMuscle = in.createStringArray();
        desc = in.readString();
        imgUrl = in.readString();
    }

    public static final Creator<Exos> CREATOR = new Creator<Exos>() {
        @Override
        public Exos createFromParcel(Parcel in) {
            return new Exos(in);
        }

        @Override
        public Exos[] newArray(int size) {
            return new Exos[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[]  getMainMuscle() {
        return mainMuscle;
    }

    public void setMainMuscle(String[]  mainMuscle) {
        this.mainMuscle = mainMuscle;
    }

    public String[]  getSecondaryMuscle() {
        return secondaryMuscle;
    }

    public void setSecondaryMuscle(String[]  secondaryMuscle) {
        this.secondaryMuscle = secondaryMuscle;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "Exos{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", mainMuscle=" + Arrays.toString(mainMuscle) +
                ", secondaryMuscle=" + Arrays.toString(secondaryMuscle) +
                ", desc='" + desc + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(title);
        parcel.writeStringArray(mainMuscle);
        parcel.writeStringArray(secondaryMuscle);
        parcel.writeString(desc);
        parcel.writeString(imgUrl);
    }
}
