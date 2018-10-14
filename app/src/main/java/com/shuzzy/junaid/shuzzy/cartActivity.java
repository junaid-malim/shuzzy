package com.shuzzy.junaid.shuzzy;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class cartActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences = getSharedPreferences("userinfo", MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();

    RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference reference = firebaseDatabase.getReference("cart").child(sharedPreferences.getString("uid","null"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView=findViewById(R.id.prodList);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(cartActivity.this));
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        recyclerView.setItemViewCacheSize(20);
    }
    public void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<model, ViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<model, ViewHolder>(model.class,R.layout.recycler_item,ViewHolder.class,reference) {
            @Override
            protected void populateViewHolder(ViewHolder viewHolder, model model, int position) {
                viewHolder.setDetails(cartActivity.this,model.getName(),model.getPrice(),model.getUrl());
            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
