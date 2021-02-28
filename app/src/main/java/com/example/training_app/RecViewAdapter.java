package com.example.training_app;

import android.content.Context;
import android.content.Intent;
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

import static com.example.training_app.ExoActivity.EXO_KEY;

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
        int len = exos.get(position).getMainMuscle().length;
        String main = "Main muscles are : ";
        for (int i = 0; i <len ; i++) {
            if(i ==0){
                main += exos.get(position).getMainMuscle()[i];
            }
            else{
                main += " and "+ exos.get(position).getMainMuscle()[i];

            }
        }

        Log.d(TAG, "onBindViewHolder: Called");
        holder.title.setText(exos.get(position).getTitle());
        holder.mainMuscle.setText(main);
        Glide.with(context).asBitmap().load(exos.get(position).getImgUrl()).into(holder.img);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ExoActivity.class);
                intent.putExtra(EXO_KEY,exos.get(position));
                context.startActivity(intent);
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
