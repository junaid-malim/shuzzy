package com.shuzzy.junaid.shuzzy;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class add_product {

    Date date = new Date();
    DatabaseReference db;
    FirebaseStorage Storage=FirebaseStorage.getInstance();
    UploadTask uploadTask;
    Uri downloadUrl;

    public add_product(final Context context, String brand, String color, String price, String filepath) {

        DateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmms");
        String strDate = dateFormat.format(date);

        final String datea=strDate;

        db = FirebaseDatabase.getInstance().getReference("shoes");

        Uri file=Uri.fromFile(new File(filepath));
        final StorageReference Sr=Storage.getReference();
        final StorageReference imgRef=Sr.child("products/"+brand+datea+".jpg");

        uploadTask = imgRef.putFile(file);

        uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                downloadUrl=Uri.parse(String.valueOf(imgRef.getDownloadUrl()));
                Toast.makeText(context,"its: "+downloadUrl,Toast.LENGTH_LONG).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(context,"not uploaded",Toast.LENGTH_LONG).show();
            }
        });


        db.child(brand+strDate).child("brand").setValue(brand);
        db.child(brand+strDate).child("color").setValue(color);
        db.child(brand+strDate).child("price").setValue(price);
        db.child(brand+strDate).child("url").setValue(downloadUrl.toString());


    }
}
