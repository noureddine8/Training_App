package com.example.training_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class All_Exos extends AppCompatActivity {
    private static final String TAG = "All_Exos";

    private RecyclerView recyclerView;
    private RecViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all__exos);

        recyclerView = findViewById(R.id.allExosRecyclerViewId);
        adapter = new RecViewAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        ArrayList<Exos> exos = Utils.getExos();
        adapter.setExos(exos);
    }
}