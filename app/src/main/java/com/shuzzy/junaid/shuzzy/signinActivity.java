package com.shuzzy.junaid.shuzzy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.firestore.FirebaseFirestore;

public class signinActivity extends AppCompatActivity {

    EditText username,password;
    Button btnsubmit;
    String usnm;
    String psswd,conpsswd;
    FirebaseFirestore Database=FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        btnsubmit=findViewById(R.id.btnsubmit);



    }
}
