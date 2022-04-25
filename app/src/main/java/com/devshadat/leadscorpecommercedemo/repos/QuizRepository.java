package com.devshadat.leadscorpecommercedemo.repos;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;

import com.devshadat.leadscorpecommercedemo.dao.CartDao;
import com.devshadat.leadscorpecommercedemo.data.CartTable;
import com.devshadat.leadscorpecommercedemo.database.CartDatabase;

import java.util.List;


public class QuizRepository {

    private CartDao mQuizDao;
    private LiveData<List<CartTable>> mAllQuestions;

    public QuizRepository(Application application) {
        CartDatabase db = CartDatabase.getInstance(application);
        mQuizDao = db.cartDao();
        mAllQuestions = mQuizDao.getAllCartProducts();
    }

    public LiveData<List<CartTable>> getmAllQuestions() {
        return mAllQuestions;
    }

    public void insert(CartTable table) {
        new InsertCourseAsyncTask(mQuizDao).execute(table);
    }

    public LiveData<List<CartTable>> getAllProducts() {
        return mAllQuestions;
    }



    private static class InsertCourseAsyncTask extends AsyncTask<CartTable, Void, Void> {
        private CartDao dao;

        private InsertCourseAsyncTask(CartDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(CartTable... model) {
            // below line is use to insert our modal in dao.
            dao.insert(model[0]);
            return null;
        }
    }
}
