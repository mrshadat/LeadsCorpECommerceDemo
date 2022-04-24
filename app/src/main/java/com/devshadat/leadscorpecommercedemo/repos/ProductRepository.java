package com.devshadat.leadscorpecommercedemo.repos;


import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.devshadat.leadscorpecommercedemo.data.Product;
import com.devshadat.leadscorpecommercedemo.request.ProductRequestAPI;
import com.devshadat.leadscorpecommercedemo.util.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRepository {

    private static final String TAG = ProductRepository.class.getSimpleName();

    private MutableLiveData<List<Product>> electronicsProducts = new MutableLiveData<>();
    private MutableLiveData<List<Product>> jeweleryProducts = new MutableLiveData<>();
    private MutableLiveData<List<Product>> menClothingProduct = new MutableLiveData<>();
    private MutableLiveData<List<Product>> womenClothingProduct = new MutableLiveData<>();

    public MutableLiveData<List<Product>> getElectronics() {

        ProductRequestAPI serviceApi =
                RetrofitClient.getClientForProduct()
                        .create(ProductRequestAPI.class);

        String endUrl = "products/category/electronics";

        serviceApi.getProductByCategory(endUrl).enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(@NonNull Call<List<Product>> call, @NonNull Response<List<Product>> response) {
                if (response.isSuccessful()) {

                    electronicsProducts.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });

        return electronicsProducts;
    }

    public MutableLiveData<List<Product>> getJewelery() {

        ProductRequestAPI serviceApi =
                RetrofitClient.getClientForProduct()
                        .create(ProductRequestAPI.class);

        String endUrl = "products/category/jewelery";

        serviceApi.getProductByCategory(endUrl).enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(@NonNull Call<List<Product>> call, @NonNull Response<List<Product>> response) {
                if (response.isSuccessful()) {

                    jeweleryProducts.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });

        return jeweleryProducts;
    }

    public MutableLiveData<List<Product>> getMenClothingProduct() {

        ProductRequestAPI serviceApi =
                RetrofitClient.getClientForProduct()
                        .create(ProductRequestAPI.class);

        String endUrl = "products/category/men's clothing";

        serviceApi.getProductByCategory(endUrl).enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(@NonNull Call<List<Product>> call, @NonNull Response<List<Product>> response) {
                if (response.isSuccessful()) {

                    menClothingProduct.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });

        return menClothingProduct;
    }


    public MutableLiveData<List<Product>> getWomenClothingProduct() {

        ProductRequestAPI serviceApi =
                RetrofitClient.getClientForProduct()
                        .create(ProductRequestAPI.class);

        String endUrl = "products/category/women's clothing";

        serviceApi.getProductByCategory(endUrl).enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(@NonNull Call<List<Product>> call, @NonNull Response<List<Product>> response) {
                if (response.isSuccessful()) {

                    womenClothingProduct.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });

        return womenClothingProduct;
    }


}
