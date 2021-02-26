package com.example.training_app;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class RecViewAdapter extends  RecyclerView.Adapter<RecViewAdapter.ViewHolder> {
    private static final String TAG = "RecViewAdapter";
    private ArrayList<Exos> exos = new ArrayList<>();
    private Context context;

    public RecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exo_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Log.d(TAG, "onBindViewHolder: Called");
        holder.title.setText(exos.get(position).getTitle());
        holder.mainMuscle.setText("Main muscle : "+exos.get(position).getMainMuscle()[0]);
        Glide.with(context).asBitmap().load(exos.get(position).getImgUrl()).into(holder.img);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Will be accomplished later", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return exos.size();
    }

    public void setExos(ArrayList<Exos> exos) {
        this.exos = exos;
        notifyDataSetChanged();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder{
        private MaterialCardView parent;
        private TextView title,mainMuscle;
        private ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent= itemView.findViewById(R.id.parentId);
            title= itemView.findViewById(R.id.exoNameId);
            mainMuscle= itemView.findViewById(R.id.mainMuscleId);
            img= itemView.findViewById(R.id.exoImageId);

        }
    }
}
