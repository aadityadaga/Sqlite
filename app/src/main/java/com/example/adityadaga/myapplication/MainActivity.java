package com.example.adityadaga.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.adityadaga.myapplication.DataBase.DatabaseHandler;
import com.example.adityadaga.myapplication.Model.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditextEmail, mEditextPassword;
    Button mBtnSubmit, mBtnRegistration;
    DatabaseHandler mDatabaseHandler ;
    List<Data>mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditextEmail = findViewById(R.id.et_Emailid);
        mEditextPassword = findViewById(R.id.et_Password);
        mBtnSubmit = findViewById(R.id.btnSubmit);
        mBtnRegistration= findViewById(R.id.btnRegistration);
        mDatabaseHandler = new DatabaseHandler(this);
        mBtnSubmit.setOnClickListener(this);
        mBtnRegistration.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnRegistration:
                Intent mIntent = new Intent(this, RegistrationActivity.class);
                startActivity(mIntent);
                break;
            case R.id.btnSubmit:
                mDatabaseHandler.open();
               if( mDatabaseHandler.checkUser(mEditextEmail.getText().toString().trim(),mEditextPassword.getText().toString().trim())){
                   Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, ListData.class);
                        startActivity(intent);
               }else{
                   Toast.makeText(this, "Please Registration", Toast.LENGTH_SHORT).show();
               }
                break;
        }

    }
}
