package com.shuzzy.junaid.shuzzy;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Product_Adapter extends RecyclerView.ViewHolder {


    Context context;

    View mView;

    public Product_Adapter(@NonNull View itemView) {
        super(itemView);
        mView=itemView;
    }


/*

    List<product> productList;


    public Product_Adapter(Context context, List<product> productList) {
        this.context = context;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=View.inflate(context,R.layout.item_product_list,null);
        TextView tvname=v.findViewById(R.id.tvname);
        TextView tvprice=v.findViewById(R.id.tvprice);

        tvname.setText(productList.get(position).getName());
        tvprice.setText(String.valueOf(productList.get(position).getPrice())+"Rs.");

        v.setTag(productList.get(position).getId());

        return v;
    }
    */
}
