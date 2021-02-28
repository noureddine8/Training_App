package com.example.training_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class ExoActivity extends AppCompatActivity implements DialogWorkoutDetails.PassWorkoutInterface {
    public static final String EXO_KEY = "EXO_KEY";
    private static final String TAG ="EXO ACTIVITY" ;

    private TextView title,main,secondary,desc;
    private Button btnAdd;
    private ImageView img;
    private String mainMuscle = "Main muscle are : ";
    private String secondMuscle = "Secondary muscle are : ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exo);

        initView();
        Intent intent = getIntent();
        if(intent != null){
            Exos exo = intent.getParcelableExtra(EXO_KEY);
            if (exo != null){
                title.setText(exo.getTitle());
                for (int i = 0; i <exo.getMainMuscle().length ; i++) {
                    if(i ==0){
                        mainMuscle += exo.getMainMuscle()[i];
                    }
                    else{
                        mainMuscle += " and "+ exo.getMainMuscle()[i];

                    }
                }
                main.setText(mainMuscle);
                for (int i = 0; i <exo.getSecondaryMuscle().length ; i++) {
                    if(i ==0){
                        secondMuscle += exo.getSecondaryMuscle()[i];
                    }
                    else{
                        secondMuscle += " and "+ exo.getSecondaryMuscle()[i];

                    }
                }
                secondary.setText(secondMuscle);
                desc.setText(exo.getDesc());
                Glide.with(this).asBitmap().load(exo.getImgUrl()).into(img);
                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DialogWorkoutDetails dialog = new DialogWorkoutDetails();
                        Bundle bundle = new Bundle();
                        bundle.putParcelable(EXO_KEY,exo);
                        dialog.setArguments(bundle);
                        dialog.show(getSupportFragmentManager(),"Dialog");
                    }
                });
            }
        }
    }

    private void initView() {
        title = findViewById(R.id.exotitleId);
        main = findViewById(R.id.mainId);
        secondary = findViewById(R.id.secondaryId);
        desc = findViewById(R.id.descId);
        btnAdd = findViewById(R.id.btnAddId);
        img = findViewById(R.id.exoPicId);
    }

    @Override
    public void getWorkout(Workout workout) {
        Log.d(TAG, "getWorkout: "+workout.toString());
        if (Utils.addWorkout(workout)){
            Toast.makeText(this, "Exercice Added to planned workout successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,PlannedWorkoutActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}