package com.devshadat.leadscorpecommercedemo.request;

import com.devshadat.leadscorpecommercedemo.data.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface ProductRequestAPI {

    @GET
    Call<List<Product>> getProductByCategory(@Url String endUrl);

    @GET
    Call<List<Product>> getMenClothingProducts(@Url String endUrl);

    @GET
    Call<List<Product>> getClothingProducts(@Url String endUrl);

    @GET
    Call<List<Product>> getWomenClothingProducts(@Url String endUrl);

}
