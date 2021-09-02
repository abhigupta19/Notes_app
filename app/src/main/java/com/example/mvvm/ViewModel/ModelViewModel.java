package com.example.mvvm.ViewModel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm.Repository.DatabaseRepo;
import com.example.mvvm.database.Model;

import java.util.List;

public class ModelViewModel extends AndroidViewModel {

    private DatabaseRepo databaseRepo;
    private LiveData<List<Model>> list;

    public ModelViewModel(Application application)
    {
        super(application);
        databaseRepo = new DatabaseRepo(application);
        list=databaseRepo.getAllList();

    }

    public  LiveData<List<Model>> getAllWords() { return list; }

    public void insert(Model word) { databaseRepo.insert(word); }

}
