package com.example.mvvm.Repository;

import android.app.Application;
import android.view.Display;

import androidx.lifecycle.LiveData;

import com.example.mvvm.database.DaoInterface;
import com.example.mvvm.database.DatabaseClass;
import com.example.mvvm.database.Model;

import java.util.List;

public class DatabaseRepo {
        private DaoInterface daoInterface;
        private LiveData<List<Model>> list;


        public DatabaseRepo(Application application){
            DatabaseClass databaseClass=DatabaseClass.getDatabase(application);
            this.daoInterface= databaseClass.wordDao();
            this.list=daoInterface.getAllModel();

        }
        public void insert(Model model){
            DatabaseClass.databaseWriteExecutor.execute(()->{
                daoInterface.insert(model);
            });
        }
        public LiveData<List<Model>> getAllList()
        {
            return  list;
        }



}
