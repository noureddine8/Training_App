package com.example.training_app;

import java.util.ArrayList;
import java.util.Arrays;

public class Exos {
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
}
