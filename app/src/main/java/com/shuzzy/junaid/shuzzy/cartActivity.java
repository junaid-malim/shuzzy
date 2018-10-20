package com.shuzzy.junaid.shuzzy;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.ByteArrayOutputStream;

public class cartActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences = getSharedPreferences("userinfo", MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPreferences.edit();

    RecyclerView recyclerView;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference reference = firebaseDatabase.getReference("cart").child(sharedPreferences.getString("uid","null"));
    int[] pricearr;

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
        FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Model, ViewHolder>(Model.class,R.layout.cart_item,ViewHolder.class,reference) {
            @Override
            protected void populateViewHolder(ViewHolder viewHolder, Model model, int position) {
                viewHolder.setDetails(cartActivity.this,model.getName(),model.getColor (),model.getPrice(),model.getUrl());
            }

            public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

                final ViewHolder viewHolder=super.onCreateViewHolder (parent, viewType);
                viewHolder.setOnClickListner (new ViewHolder.ClickListner () {
                    @Override
                    public void onItemClick(View view, int position) {
                        TextView tvname=view.findViewById (R.id.tvname);
                        TextView tvprice=view.findViewById (R.id.tvprice);
                        ImageView prodimg=view.findViewById (R.id.prodimg);

                        String refr=getRef (position).getKey ();
                        String mname=tvname.getText ().toString ();
                        String nprice=tvprice.getText ().toString ();
                        Drawable mDrawable=prodimg.getDrawable ();
                        Bitmap mBitmap=((BitmapDrawable)mDrawable).getBitmap ();

                        Intent intent=new Intent (view.getContext (),viewprodActivity.class);
                        ByteArrayOutputStream stream=new ByteArrayOutputStream ();
                        mBitmap.compress (Bitmap.CompressFormat.PNG,100,stream);
                        byte[] bytes=stream.toByteArray ();
                        intent.putExtra ("image",bytes);
                        intent.putExtra ("name",mname);
                        intent.putExtra ("price",nprice);
                        intent.putExtra ("reference",refr);

                        startActivity (intent);
                    }
                });



                return viewHolder;
            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}
