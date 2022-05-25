package com.rajendra.onlinedailygroceries.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.rajendra.onlinedailygroceries.ProductDetailActivity;
import com.rajendra.onlinedailygroceries.R;
import com.rajendra.onlinedailygroceries.model.Product;
import com.rajendra.onlinedailygroceries.model.ProductDetail;
import com.rajendra.onlinedailygroceries.network.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class info_pro_Fragment extends Fragment {
    public Context context;
    public info_pro_Fragment( Context context) {
        this.context = context;
    }

    TextView name, price, quanity, tag, status, description, detail, specification;
    Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_info_pro, container, false);

       // Toast.makeText(context, "tsst", Toast.LENGTH_LONG).show();


        name = view.findViewById(R.id.txtNameProductDe);
        price = view.findViewById(R.id.txtPriceProductDe);
        quanity = view.findViewById(R.id.txtQuantityProductDe);
        tag = view.findViewById(R.id.txtTagProductDe);
        status = view.findViewById(R.id.txtStatusProductDe);
        description = view.findViewById(R.id.txtProductDeDescription);
        detail = view.findViewById(R.id.txtProductDeDetail);
        specification = view.findViewById(R.id.txtProductDeSpecification);
//
        Product pro = ProductDetailActivity.getProductDetail();
//        description.setText(pro.toString());
        Call<ProductDetail> proDe = ApiClient.getNewsService().getProductDetail(pro.getId());
//        description.setText(proDe.toString());
        proDe.enqueue(new Callback<ProductDetail>() {
            @Override
            public void onResponse(Call<ProductDetail> call, Response<ProductDetail> response) {
//                Toast.makeText(context, response.body().toString(), Toast.LENGTH_LONG).show();
//               Log.e("hi",response.body().toString());
                name.setText(response.body().getName());
                price.setText(String.valueOf(response.body().getPrice()) );
                quanity.setText(String.valueOf(response.body().getQuantity()) );
                tag.setText(response.body().getTag());
                status.setText(response.body().getStatus());
                description.setText(response.body().getDescription());
                detail.setText(response.body().getDetails());
                specification.setText(response.body().getSpecifications());

            }

            @Override
            public void onFailure(Call<ProductDetail> call, Throwable t) {
                Toast.makeText(context, "bug", Toast.LENGTH_LONG).show();

            }
        });

        return view;
    }
}