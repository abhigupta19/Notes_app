package com.example.mvvm.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoInterface {
    @Insert
    void  insert(Model model);
    @Delete
    void  delete(Model model);
    @Query("Select * from notes order by id ASC")
    LiveData<List<Model>> getAllModel();
}
