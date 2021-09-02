package com.example.mvvm.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Model.class},version = 1,exportSchema = false)
public abstract  class DatabaseClass extends RoomDatabase {


    public abstract DaoInterface wordDao();



    private static volatile DatabaseClass INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;

    public  static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

     public  static DatabaseClass getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DatabaseClass.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DatabaseClass.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;

    }



}
