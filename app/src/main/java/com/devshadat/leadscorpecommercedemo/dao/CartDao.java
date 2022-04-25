package com.devshadat.leadscorpecommercedemo.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import com.devshadat.leadscorpecommercedemo.data.CartTable;

import java.util.List;

@Dao
public interface CartDao {

    @Query("SELECT * FROM cart_table")
    LiveData<List<CartTable>> getAllCartProducts();

    @Insert
    void insert(CartTable quizTable);

}
