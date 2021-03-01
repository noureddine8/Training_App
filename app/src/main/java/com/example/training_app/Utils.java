package com.example.training_app;

import java.util.ArrayList;

public class Utils {

    private static ArrayList<Exos> exos;

    public static ArrayList<Workout> getWorkouts() {
        return workouts;
    }

    private static ArrayList<Workout> workouts;

    public static void initExos() {
        Exos pushUp = new Exos(1, "Push Ups", new String[]{"Chest", "Triceps"}, new String[]{"Forearms", "Biceps"}, "One of the most important exercices in body-building, Traditional pushups are beneficial for building upper body strength. They work the triceps, pectoral muscles, and shoulders. When done with proper form, they can also strengthen the lower back and core by engaging (pulling in) the abdominal muscles. One of the most important exercices in body-building, Traditional pushups are beneficial for building upper body strength. They work the triceps, pectoral muscles, and shoulders. When done with proper form, they can also strengthen the lower back and core by engaging (pulling in) the abdominal muscles", "https://www.muscleandfitness.com/wp-content/uploads/2018/02/1109-feet-elevated-pushup.jpg?quality=86&strip=all.png");
        Exos pullup = new Exos(2, "Pull Ups", new String[]{"Back", "Biceps"}, new String[]{"Forearms", "Traps"}, " The basic bodyweight back exercice ", "https://www.t-nation.com/system/publishing/articles/10007940/original/Double-Your-Pull-Ups-in-30-Days.jpeg?1587490644.png");
        if (exos == null) {
            exos = new ArrayList<>();
            exos.add(pushUp);
            exos.add(pullup);
        }

    }

    public static ArrayList<Exos> getExos() {
        return exos;
    }
    public static boolean addWorkout(Workout workout){
        if (workouts == null){
            workouts = new ArrayList<>();
        }
        return workouts.add(workout);
    }
}
