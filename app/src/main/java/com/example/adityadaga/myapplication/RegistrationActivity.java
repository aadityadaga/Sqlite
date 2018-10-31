package com.example.adityadaga.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.adityadaga.myapplication.DataBase.DatabaseHandler;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    EditText mEditextEmail, mEditextPassword,mEditextConfirmPassword;
    Button mBtnSubmit;
    DatabaseHandler mDatabaseHandler ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mDatabaseHandler = new DatabaseHandler(this);
        mEditextEmail = findViewById(R.id.et_Emailid);
        mEditextPassword = findViewById(R.id.et_Password);
        mEditextConfirmPassword = findViewById(R.id.et_ConfirmPassword);
        mBtnSubmit = findViewById(R.id.btnSubmit);
        mBtnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(CheckValidity()){
            mDatabaseHandler.open();
              mDatabaseHandler.insert(mEditextEmail.getText().toString(),mEditextPassword.getText().toString() );
            Intent mIntent = new Intent(this, MainActivity.class);
            startActivity(mIntent);
        }


    }

    private boolean CheckValidity() {

        if(mEditextEmail.getText().toString().isEmpty()){
            mEditextEmail.setError("Enter Email");
            return false;
        }if(mEditextPassword.getText().toString().isEmpty()){
            mEditextPassword.setError("Enter Password");
            return false;
        }if(!mEditextPassword.getText().toString().equals(mEditextConfirmPassword.getText().toString()))
        {
            mEditextConfirmPassword.setError("Enter Password Again");
            return false;
        }
        if(mEditextPassword.getText().toString().toCharArray().length<8){
            mEditextPassword.setError("Enter min 8 and max 15 character Password");
            return false;
        }
        return true;
    }
}
