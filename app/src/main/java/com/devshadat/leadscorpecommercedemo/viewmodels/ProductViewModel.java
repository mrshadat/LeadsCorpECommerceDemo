package com.devshadat.leadscorpecommercedemo.viewmodels;

import android.location.Location;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.devshadat.leadscorpecommercedemo.data.Product;
import com.devshadat.leadscorpecommercedemo.repos.ProductRepository;

import java.util.List;

public class ProductViewModel extends ViewModel {

    private ProductRepository repository;
    public MutableLiveData<String> electronicsQuantity = new MutableLiveData<>();
    public MutableLiveData<String> jeweleryQuantity = new MutableLiveData<>();
    public MutableLiveData<String> menClothQuantity = new MutableLiveData<>();
    public MutableLiveData<String> womenClothQuantity = new MutableLiveData<>();

    public ProductViewModel() {
        repository = new ProductRepository();
    }

    public MutableLiveData<List<Product>> getAllElectronicProducts() {
        return repository.getElectronics();

    }

    public MutableLiveData<List<Product>> getAllJeweleryProducts() {
        return repository.getJewelery();

    }

    public MutableLiveData<List<Product>> getAllMenClothingProducts() {
        return repository.getMenClothingProduct();

    }

    public MutableLiveData<List<Product>> getAllWomenClothingProducts() {
        return repository.getWomenClothingProduct();

    }

}
