package com.shuzzy.junaid.shuzzy;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {

    View mView;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mView=itemView;

    }
    public void setDetails(MainActivity context, String name, String price, String image) {

        TextView tvname=mView.findViewById(R.id.tvname);
        TextView tvprice=mView.findViewById(R.id.tvprice);
        ImageView prodimg=mView.findViewById(R.id.prodimg);

        tvname.setText(name);
        tvprice.setText(price);
        Picasso.get().load(image).into(prodimg);

    }
}
