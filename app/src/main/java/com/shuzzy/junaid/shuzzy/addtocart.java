package com.shuzzy.junaid.shuzzy;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.content.Context.MODE_PRIVATE;

public class addtocart {

    DatabaseReference db;
    DataSnapshot ds;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public addtocart(final Context context,String refkey){

        sharedPreferences = context.getSharedPreferences ("userinfo", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        String dsbrand=ds.child (refkey).child ("brand").getValue ().toString ();
        String dscolor=ds.child (refkey).child ("color").getValue ().toString ();
        String dsprice=ds.child (refkey).child ("price").getValue ().toString ();
        String dsurl=ds.child (refkey).child ("url").getValue ().toString ();

        db = FirebaseDatabase.getInstance().getReference("cart").child(sharedPreferences.getString("uid","null")).child (refkey);

        db.child ("brand").setValue (dsbrand);
        db.child ("color").setValue (dscolor);
        db.child ("price").setValue (dsprice);
        db.child ("url").setValue (dsurl);


    }
}
