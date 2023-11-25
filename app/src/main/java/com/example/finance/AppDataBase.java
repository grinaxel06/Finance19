package com.example.finance;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import database.data.OperationDatabase;

public class AppDataBase {

    private static OperationDatabase instance;


    public static synchronized OperationDatabase getInstance(Context context) {
        if (instance == null) {
            RoomDatabase.Callback myCallBack = new RoomDatabase.Callback() {
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                }
            };

            instance = Room.databaseBuilder(context, OperationDatabase.class, "OperationDB").addCallback(myCallBack).allowMainThreadQueries().build();
        }
        return instance;
    }

}
