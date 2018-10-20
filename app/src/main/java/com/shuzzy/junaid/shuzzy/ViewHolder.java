package com.shuzzy.junaid.shuzzy;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.LruCache;
import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder {

    View mView;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        mView=itemView;

        itemView.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                mClickListner.onItemClick (view,getAdapterPosition ());
            }
        });

    }
    public void setDetails(MainActivity context, String name,String color, String price, String image) {

        TextView tvname=mView.findViewById(R.id.tvname);
        TextView tvprice=mView.findViewById(R.id.tvprice);
        ImageView prodimg=mView.findViewById(R.id.prodimg);

        tvname.setText(name+" "+color);
        tvprice.setText(price);
        Picasso p=new Picasso.Builder(context).memoryCache(new LruCache(240000)).build();
        p.load(image).resize(1080,1080).centerInside().placeholder(R.drawable.progress_animation).error(R.drawable.error_icon).into(prodimg);


    }

    public interface ClickListner{
        void onItemClick(View view,int position);
    }
    ViewHolder.ClickListner mClickListner;
    public void setOnClickListner(ViewHolder.ClickListner clickListner){
        mClickListner=clickListner;
    }

    public void setDetails(cartActivity context, String name,String color, String price, String image) {

        TextView tvname=mView.findViewById(R.id.tvname);
        TextView tvprice=mView.findViewById(R.id.tvprice);
        ImageView prodimg=mView.findViewById(R.id.prodimg);

        tvname.setText(name+" "+color);
        tvprice.setText(price);
        Picasso p=new Picasso.Builder(context).memoryCache(new LruCache(240000)).build();
        p.load(image).resize(1080,1080).centerInside().placeholder(R.drawable.progress_animation).error(R.drawable.error_icon).into(prodimg);


    }
    public void setDetails(wishlistActivity context, String name,String color, String price, String image) {

        TextView tvname=mView.findViewById(R.id.tvname);
        TextView tvprice=mView.findViewById(R.id.tvprice);
        ImageView prodimg=mView.findViewById(R.id.prodimg);

        tvname.setText(name+" "+color);
        tvprice.setText(price);
        Picasso p=new Picasso.Builder(context).memoryCache(new LruCache(240000)).build();
        p.load(image).resize(1080,1080).centerInside().placeholder(R.drawable.progress_animation).error(R.drawable.error_icon).into(prodimg);


    }

}
