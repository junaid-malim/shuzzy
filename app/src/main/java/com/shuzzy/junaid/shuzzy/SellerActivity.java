package com.shuzzy.junaid.shuzzy;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;

public class SellerActivity extends AppCompatActivity {

    StorageReference storageReference;

    Button button;

    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);
        storageReference=FirebaseStorage.getInstance().getReference();

        button=findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFolder();
            }
        });

    }
    public void openFolder(){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        uri = Uri.parse(Environment.getExternalStorageDirectory().getPath()
                +  File.separator + "myFolder" + File.separator);
        intent.setDataAndType(uri, "image/jpg");
        startActivity(Intent.createChooser(intent, "Open folder"));
    }
}
