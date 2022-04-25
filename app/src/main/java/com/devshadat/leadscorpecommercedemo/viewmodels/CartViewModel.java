package com.devshadat.leadscorpecommercedemo.viewmodels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.devshadat.leadscorpecommercedemo.data.CartTable;
import com.devshadat.leadscorpecommercedemo.repos.QuizRepository;

import java.util.List;


public class CartViewModel extends AndroidViewModel {

    private QuizRepository mRepository;

    private LiveData<List<CartTable>> mAllQuestions;

    public CartViewModel(Application application) {
        super(application);
        mRepository = new QuizRepository(application);
        mAllQuestions = mRepository.getAllProducts();
    }

    public LiveData<List<CartTable>> getmAllQuestions() {
        return mAllQuestions;
    }

    public void insert(CartTable model) {
        mRepository.insert(model);
    }

}
