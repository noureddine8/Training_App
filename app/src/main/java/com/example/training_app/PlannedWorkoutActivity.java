package com.example.training_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlannedWorkoutActivity extends AppCompatActivity {
    private TextView mondayText, tuesdayText, wednesdayText, thursdayText, fridayText, saturdayText, sundayText;
    private RecyclerView mondayRec, tuesdayRec, wednesdayRec, thursdayRec, fridayRec, saturdayRec, sundayRec;
    private RelativeLayout noPlanLayout;
    private ScrollView scrollView;
    private Button noPlanBtn;
    private PlanItemRecView mondayRecAdapt, tuesdayRecAdapt, wednesdayRecAdapt, thursdayRecAdapt, fridayRecAdapt, saturdayRecAdapt, sundayRecAdapt;
    private static final String TAG = "PlannedWorkoutActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planned_workout);

        initView();
        ArrayList<Workout> workouts = Utils.getWorkouts();
        if (workouts != null) {
            if(workouts.size() > 0){
                noPlanLayout.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
                initRecView();

            }else{
                noPlanLayout.setVisibility(View.VISIBLE);
                scrollView.setVisibility(View.GONE);
                noPlanBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(PlannedWorkoutActivity.this,All_Exos.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                });
            }
        } else {
            noPlanLayout.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
            noPlanBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(PlannedWorkoutActivity.this,All_Exos.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            });
        }
    }

    private void initRecView() {
        Log.d(TAG, "initRecView: Started");
        
    }

    private void initView() {

        mondayText = findViewById(R.id.mondayEdit);
        tuesdayText = findViewById(R.id.tuesdayEdit);
        wednesdayText = findViewById(R.id.wednesdayEdit);
        thursdayText = findViewById(R.id.thursdayEdit);
        fridayText = findViewById(R.id.fridayEdit);
        saturdayText = findViewById(R.id.saturdayEdit);
        sundayText = findViewById(R.id.sundayEdit);

        mondayRec = findViewById(R.id.mondayRecId);
        tuesdayRec = findViewById(R.id.tuesdayRecId);
        wednesdayRec = findViewById(R.id.wednesdayRecId);
        thursdayRec = findViewById(R.id.thursdayRecId);
        fridayRec = findViewById(R.id.fridayRecId);
        saturdayRec = findViewById(R.id.saturdayRecId);
        sundayRec = findViewById(R.id.sundayRecId);

        noPlanLayout = findViewById(R.id.noPlanLayoutId);

        scrollView = findViewById(R.id.plannedScrollId);

        noPlanBtn = findViewById(R.id.noPlanBtnId);


    }
}