package com.devshadat.leadscorpecommercedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.devshadat.leadscorpecommercedemo.data.Product;
import com.devshadat.leadscorpecommercedemo.databinding.ActivityProductDetailsBinding;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductDetailsActivity extends AppCompatActivity {

    private ActivityProductDetailsBinding binding;
    private Product product;
    ArrayList<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_details);
        productList = new ArrayList<>();

        Gson gson = new Gson();
        product = gson.fromJson(getIntent().getStringExtra("PRODUCT"), Product.class);

        String price = "BDT " + String.valueOf(product.getPrice());

        binding.productNameTextView.setText(product.getTitle());
        binding.priceTextView.setText(price);

        if (product.getImage() != null) {
            String imageUrl = product.getImage();
            Picasso.get().load(imageUrl).into(binding.productImageView);
        }

        binding.addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        binding.fabCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductDetailsActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
    }
}