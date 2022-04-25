package com.devshadat.leadscorpecommercedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.devshadat.leadscorpecommercedemo.data.CartTable;
import com.devshadat.leadscorpecommercedemo.data.Product;
import com.devshadat.leadscorpecommercedemo.databinding.ActivityProductDetailsBinding;
import com.devshadat.leadscorpecommercedemo.viewmodels.CartViewModel;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Objects;

public class ProductDetailsActivity extends AppCompatActivity {

    private ActivityProductDetailsBinding binding;
    private Product product;
    ArrayList<Product> productList;
    private CartViewModel cartViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_details);
        cartViewModel = ViewModelProviders.of(this).get(CartViewModel.class);

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
                String name = product.getTitle();
                String price = String.valueOf(product.getPrice());
                String description = product.getDescription();
                String category = product.getCategory();
                String image = product.getImage();

                CartTable table = new CartTable(name, price, description, category, image);
                cartViewModel.insert(table);
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