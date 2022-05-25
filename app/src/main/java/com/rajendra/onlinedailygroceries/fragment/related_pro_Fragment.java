package com.rajendra.onlinedailygroceries.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rajendra.onlinedailygroceries.ProductDetailActivity;
import com.rajendra.onlinedailygroceries.R;
import com.rajendra.onlinedailygroceries.adapter.AllProductAdapter;
import com.rajendra.onlinedailygroceries.model.AllProducts;
import com.rajendra.onlinedailygroceries.model.Product;
import com.rajendra.onlinedailygroceries.network.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class related_pro_Fragment extends Fragment {

    RecyclerView allProRecycler;
    AllProductAdapter allProductAdapter;

    public related_pro_Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_related_pro, container, false);

        final Product pro = ProductDetailActivity.getProductDetail();
        String status = pro.getStatus();
        allProRecycler = view.findViewById(R.id.allProductRecycler);
        final List<Product> allList = new ArrayList<>();
        Call<List<Product>> listPro = ApiClient.getNewsService().getAllProduct(status);
        listPro.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {

                allList.addAll(response.body());
                for(int i = 0; i <= allList.size(); i++) {
                    if (response.body().get(i).getId() == pro.getId()) {
                        allList.remove(i);
                    }
                }
                getAllProduct(allList);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });

//        allList.add(new AllProducts(1, "abd efg air vvv alibaba vvv vvv hmm omg s", "New Arrival", 24, 54, R.drawable.b4));
//        allList.add(new AllProducts(1, "ha hbn hiab sfss", "New jghk", 56, 78, R.drawable.b4));
//        allList.add(new AllProducts(1, "camera abc", "Best Seller", 234, 34, R.drawable.b4));
//        allList.add(new AllProducts(1, "abd efg air conditional alibaba omg luon hmm omg s", "New Arrival", 12, 1, R.drawable.b4));
//        allList.add(new AllProducts(1, "ahh aahh", "New bebib", 33, 34, R.drawable.b4));
//        allList.add(new AllProducts(1, "abd efg air nmsds alibaba omg luon hmm omg s", "New abcd", 11, 9, R.drawable.b4));

        return view;
    }

    private void getAllProduct(List<Product> allList) {
        allProductAdapter = new AllProductAdapter(this.getContext(), allList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.getContext(), 2, GridLayoutManager.VERTICAL, false);
        allProRecycler.setLayoutManager(gridLayoutManager);
        allProRecycler.setAdapter(allProductAdapter);
    }
}