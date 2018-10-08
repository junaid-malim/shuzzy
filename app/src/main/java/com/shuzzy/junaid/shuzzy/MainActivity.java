package com.shuzzy.junaid.shuzzy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Product_Adapter adapter;
    List<product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);

        productList=new ArrayList<>();

        productList.add(new product(1,1000,"the shoe"));
        productList.add(new product(2,1000,"the shoe"));
        productList.add(new product(3,1000,"the shoe"));
        productList.add(new product(4,1000,"the shoe"));
        productList.add(new product(5,1000,"the shoe"));
        productList.add(new product(6,1000,"the shoe"));
        productList.add(new product(7,1000,"the shoe"));
        productList.add(new product(7,1000,"the shoe"));
        productList.add(new product(8,1000,"the shoe"));
        productList.add(new product(9,1000,"the shoe"));
        productList.add(new product(10,1000,"the shoe"));
        productList.add(new product(11,1000,"the shoe"));
        productList.add(new product(12,1000,"the shoe"));
        productList.add(new product(13,1000,"the shoe"));
        productList.add(new product(14,1000,"the shoe"));
        productList.add(new product(15,1000,"the shoe"));

        adapter=new Product_Adapter(getApplicationContext(),productList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"clicked",Toast.LENGTH_LONG).show();
            }
        });

    }
}
