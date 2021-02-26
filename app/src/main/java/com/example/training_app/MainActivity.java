package com.example.training_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private Button plannedWorkout,allExos,aboutUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utils.initExos();
        initView();
        allExos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,All_Exos.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        Log.d(TAG, "initView: Started");
        plannedWorkout = findViewById(R.id.myPlansId);
        allExos = findViewById(R.id.allExosId);
        aboutUs = findViewById(R.id.aboutUsId);
    }
}