package com.shuzzy.junaid.shuzzy;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference reference = firebaseDatabase.getReference("shoes");


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.prodList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


    }

    public void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<model, ViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<model, ViewHolder>(model.class,R.layout.recycler_item,ViewHolder.class,reference) {
            @Override
            protected void populateViewHolder(ViewHolder viewHolder, model model, int position) {
                viewHolder.setDetails(MainActivity.this,model.getName(),model.getPrice(),model.getUrl());
            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
