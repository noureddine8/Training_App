package com.example.training_app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import static com.example.training_app.ExoActivity.EXO_KEY;

public class DialogWorkoutDetails extends DialogFragment {

    public interface PassWorkoutInterface{
        void getWorkout(Workout workout);
    }

    private TextView exoName;
    private EditText sets,reps;
    private Button add,dismiss;
    private Spinner spinner;

    private PassWorkoutInterface passWorkoutInterface;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_workout_details,null);
        initView(view);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity()).setView(view).setTitle("Workout Plan");
        Bundle bundle = getArguments();
        if (bundle != null){
            Exos exo = bundle.getParcelable(EXO_KEY);
            if (exo != null){
                exoName.setText(exo.getTitle());
                dismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dismiss();
                    }
                });
                add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int setsValue = Integer.valueOf(sets.getText().toString());
                        int repsValue = Integer.valueOf(reps.getText().toString());
                        String day = spinner.getSelectedItem().toString();
                        Workout workout = new Workout(exo,setsValue,repsValue,day,false);

                        try {
                            passWorkoutInterface = (PassWorkoutInterface) getActivity();
                            passWorkoutInterface.getWorkout(workout);
                            dismiss();
                        }catch (ClassCastException e){
                            e.printStackTrace();
                            dismiss();
                        }

                    }
                });
            }
        }
        return builder.create();
    }

    private void initView(View view) {
        exoName = view.findViewById(R.id.dialogExoName);
        sets = view.findViewById(R.id.dialogSets);
        reps = view.findViewById(R.id.dialogReps);
        add = view.findViewById(R.id.dialogAdd);
        dismiss = view.findViewById(R.id.dialogDismiss);
        spinner = view.findViewById(R.id.dialogDays);
    }
}
