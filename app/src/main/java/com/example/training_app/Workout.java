package com.example.training_app;

import android.os.Parcel;
import android.os.Parcelable;

public class Workout implements Parcelable {
    private Exos exo;
    private int sets;
    private int reps;
    private String date;
    private boolean isDone;

    @Override
    public String toString() {
        return "Workout{" +
                "exo=" + exo +
                ", sets=" + sets +
                ", reps=" + reps +
                ", date='" + date + '\'' +
                ", isDone=" + isDone +
                '}';
    }

    public Workout(Exos exo, int sets, int reps, String date, boolean isDone) {
        this.exo = exo;
        this.sets = sets;
        this.reps = reps;
        this.date = date;
        this.isDone = isDone;
    }

    protected Workout(Parcel in) {
        exo = in.readParcelable(Exos.class.getClassLoader());
        sets = in.readInt();
        reps = in.readInt();
        date = in.readString();
        isDone = in.readByte() != 0;
    }

    public static final Creator<Workout> CREATOR = new Creator<Workout>() {
        @Override
        public Workout createFromParcel(Parcel in) {
            return new Workout(in);
        }

        @Override
        public Workout[] newArray(int size) {
            return new Workout[size];
        }
    };

    public Exos getExo() {
        return exo;
    }

    public void setExo(Exos exo) {
        this.exo = exo;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(exo, i);
        parcel.writeInt(sets);
        parcel.writeInt(reps);
        parcel.writeString(date);
        parcel.writeByte((byte) (isDone ? 1 : 0));
    }
}
