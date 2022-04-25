package com.devshadat.leadscorpecommercedemo.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.devshadat.leadscorpecommercedemo.dao.CartDao;
import com.devshadat.leadscorpecommercedemo.data.CartTable;


@Database(entities = {CartTable.class}, version = 1)
public abstract class CartDatabase extends RoomDatabase {

    private static CartDatabase INSTANCE;

    public abstract CartDao cartDao();

    public static synchronized CartDatabase getInstance(final Context context) {

        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), CartDatabase.class, "quiz_db")
                    .fallbackToDestructiveMigration()
                    .addCallback(RoomDBCallback)
                    .build();
        }

        return INSTANCE;
    }

    private static RoomDatabase.Callback RoomDBCallback = new RoomDatabase.Callback() {

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            new PopulateDbAsyncTask(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        private CartDao quizDao;

        private PopulateDbAsyncTask(CartDatabase db) {
            quizDao = db.cartDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            return null;
        }
    }
}
