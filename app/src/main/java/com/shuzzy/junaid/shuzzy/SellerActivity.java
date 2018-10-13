package com.shuzzy.junaid.shuzzy;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.CursorLoader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.text.SimpleDateFormat;

public class SellerActivity extends AppCompatActivity {

    StorageReference storageReference;

    ImageView imageView;
    TextView textView;
    EditText getColor1,getBrand,getPrice;
    Button Submit;


    static final int PICK_IMAGE_REQUEST = 1;
    String filePath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);
        storageReference=FirebaseStorage.getInstance().getReference();
        imageView=findViewById(R.id.smpl);
        textView=findViewById(R.id.textView);
        getBrand=findViewById(R.id.getBrand);
        getPrice=findViewById(R.id.getPrice);
        getColor1=findViewById(R.id.getColor1);
        Submit=findViewById(R.id.button);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new add_product(SellerActivity.this,getBrand.getText().toString(),getColor1.getText().toString(),getPrice.getText().toString(),filePath);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageBrowse();
            }
        });

    }


    private void imageBrowse() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            if(requestCode == PICK_IMAGE_REQUEST){
                Uri picUri = data.getData();

                filePath = getPath(picUri);

                if (picUri != null) {
                    Log.d("picUri", picUri.toString());
                }
                else {
                    Toast.makeText(SellerActivity.this, "nulla", Toast.LENGTH_LONG).show();
                }
                Log.d("filePath", filePath);
                textView.setVisibility(View.GONE);
                imageView.setImageURI(picUri);

            }

        }

    }
    private String getPath(Uri contentUri) {
        String[] proj = { MediaStore.Images.Media.DATA };
        CursorLoader loader = new CursorLoader(getApplicationContext(), contentUri, proj, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int column_index = 0;
        if (cursor != null) {
            column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        }
        else{
            Toast.makeText(SellerActivity.this,"coloumn nulla",Toast.LENGTH_LONG).show();
        }
        if (cursor != null) {
            cursor.moveToFirst();
        }
        String result = cursor.getString(column_index);
        cursor.close();
        return result;
    }

}
