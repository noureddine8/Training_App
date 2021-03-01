package com.example.training_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

import static com.example.training_app.ExoActivity.EXO_KEY;

public class PlanItemRecView extends RecyclerView.Adapter<PlanItemRecView.ViewHolder> {
    private ArrayList<Workout> workouts = new ArrayList<>();
    private Context context;

    public PlanItemRecView(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.planned_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(workouts.get(position).getExo().getTitle());
        holder.reps.setText(workouts.get(position).getReps());
        holder.sets.setText(workouts.get(position).getSets());
        Glide.with(context).asBitmap().load(workouts.get(position).getExo().getImgUrl()).into(holder.img);
        if(workouts.get(position).isDone()){
            holder.checked.setVisibility(View.VISIBLE);
            holder.empty.setVisibility(View.GONE);
        } else{
            holder.checked.setVisibility(View.GONE);
            holder.empty.setVisibility(View.VISIBLE);
        }
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ExoActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra(EXO_KEY,workouts.get(position).getExo());
            }
        });

    }

    @Override
    public int getItemCount() {
        return workouts.size();
    }

    public void setWorkouts(ArrayList<Workout> workouts) {
        this.workouts = workouts;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private MaterialCardView parent;
        private TextView title,reps,sets;
        private ImageView img,empty,checked;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parentItemId);
            title = itemView.findViewById(R.id.plannedItemTextId);
            reps = itemView.findViewById(R.id.repsItemId);
            sets = itemView.findViewById(R.id.setsItemId);
            img = itemView.findViewById(R.id.trainingImgId);
            checked = itemView.findViewById(R.id.checkedCircleId);
            empty = itemView.findViewById(R.id.emptyCircleId);
        }
    }

}
