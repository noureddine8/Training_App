package com.example.training_app;

import java.util.ArrayList;

public class Utils {

    private static ArrayList<Exos> exos;

    public static void initExos() {
        Exos pushUp = new Exos(1, "Push Ups", new String[]{"Chest", "Triceps"}, new String[]{"Forarms", "Biceps"}, "One of the most important exercice in body building", "https://www.muscleandfitness.com/wp-content/uploads/2018/02/1109-feet-elevated-pushup.jpg?quality=86&strip=all.png");
        Exos pullup = new Exos(2, "Pull Ups", new String[]{"Back", "Biceps"}, new String[]{"Forarms", "Traps"}, " The basic bodyweight back exercice ", "https://www.t-nation.com/system/publishing/articles/10007940/original/Double-Your-Pull-Ups-in-30-Days.jpeg?1587490644.png");
        if (exos == null) {
            exos = new ArrayList<>();
            exos.add(pushUp);
            exos.add(pullup);
        }

    }

    public static ArrayList<Exos> getExos() {
        return exos;
    }
}
