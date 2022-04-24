package com.devshadat.leadscorpecommercedemo.request;

import com.devshadat.leadscorpecommercedemo.data.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryRequestAPI {

    @GET("products/categories")
    Call<List<Category>> getAllCategories();
}
