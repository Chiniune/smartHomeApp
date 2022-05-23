package com.rajendra.onlinedailygroceries.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rajendra.onlinedailygroceries.R;
import com.rajendra.onlinedailygroceries.model.AllProducts;

import java.util.List;

public class AllProductAdapter extends RecyclerView.Adapter<AllProductAdapter.AllProductViewHolder> {

    Context context;
    List<AllProducts> lisPro;

    public AllProductAdapter(Context context, List<AllProducts> listComment) {
        this.context = context;
        this.lisPro = listComment;
    }

    @NonNull
    @Override
    public AllProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.all_pro_item, parent, false);

        return new AllProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllProductViewHolder holder, @SuppressLint("RecyclerView") final int position) {

        holder.proName.setText(lisPro.get(position).getProductName());
        holder.price.setText(String.valueOf(lisPro.get(position).getProductPrice()) + "$");
        holder.sold.setText("Sold " + String.valueOf(lisPro.get(position).getSold()));
        holder.status.setText(lisPro.get(position).getStatus());
        holder.imgurl.setBackgroundResource(lisPro.get(position).getImageUrl());

    }

    @Override
    public int getItemCount() {
        return lisPro.size();
    }

    public static class AllProductViewHolder extends RecyclerView.ViewHolder{

        TextView proName, status, sold, price;
        ImageView imgurl;

        public AllProductViewHolder(@NonNull View itemView) {
            super(itemView);

            proName = itemView.findViewById(R.id.proNameGrid);
            status = itemView.findViewById(R.id.textsale);
            sold = itemView.findViewById(R.id.proSold);
            price = itemView.findViewById(R.id.proPrice);
            imgurl = itemView.findViewById(R.id.imageProductGrid);
        }
    }

}
