package com.example.adityadaga.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.adityadaga.myapplication.Adapter.RecyclerViewAdapter;
import com.example.adityadaga.myapplication.DataBase.DatabaseHandler;
import com.example.adityadaga.myapplication.Model.Data;

import java.util.ArrayList;
import java.util.List;

public class ListData extends AppCompatActivity {
    RecyclerView mRecyclerView;
    RecyclerViewAdapter mRecyclerViewAdapter;
    List<Data> mList = new ArrayList();
    private DatabaseHandler mDatabaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);
        mRecyclerView = findViewById(R.id.RecyclerView);
        mDatabaseHandler = new DatabaseHandler(this);
        mDatabaseHandler.open();
        mList = mDatabaseHandler.getAll();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerViewAdapter = new RecyclerViewAdapter(this, mList);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

    }
}
