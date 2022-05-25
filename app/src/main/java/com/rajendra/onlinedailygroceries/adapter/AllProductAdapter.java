package com.rajendra.onlinedailygroceries.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.rajendra.onlinedailygroceries.Constants;
import com.rajendra.onlinedailygroceries.ProductDetailActivity;
import com.rajendra.onlinedailygroceries.R;
import com.rajendra.onlinedailygroceries.model.AllProducts;
import com.rajendra.onlinedailygroceries.model.Product;

import java.io.Serializable;
import java.util.List;

public class AllProductAdapter extends RecyclerView.Adapter<AllProductAdapter.AllProductViewHolder> {

    Context context;
    List<Product> lisPro;

    public AllProductAdapter(Context context, List<Product> listComment) {
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

        holder.proName.setText(lisPro.get(position).getName());
        holder.price.setText(String.valueOf(lisPro.get(position).getPrice()) + "$");
        holder.sold.setText("View " + String.valueOf(lisPro.get(position).getView()));
        holder.status.setText(lisPro.get(position).getStatus());
        Glide.with(context).load("http://"+ Constants.Host +":8080/User/assets/images/product/"+
                lisPro.get(position).getImage()).into(holder.imgurl);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProductDetailActivity.class);
                intent.putExtra("product", (Serializable) lisPro.get(position));
                context.startActivity(intent);
            }
        });

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
