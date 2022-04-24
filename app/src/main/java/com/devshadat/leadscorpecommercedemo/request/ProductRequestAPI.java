package com.devshadat.leadscorpecommercedemo.request;

import com.devshadat.leadscorpecommercedemo.data.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductRequestAPI {

    @GET("products/category/jewelery")
    Call<List<Product>> getAllProducts();

}
