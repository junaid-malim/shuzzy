package com.shuzzy.junaid.shuzzy;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class wishlistActivity extends AppCompatActivity {


    SharedPreferences sharedPreferences = getSharedPreferences("userinfo", MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();

    RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference reference = firebaseDatabase.getReference("wishlist").child(sharedPreferences.getString("uid","null"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);



    }
}
