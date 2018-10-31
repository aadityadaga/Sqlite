package com.example.adityadaga.myapplication.Model;

import java.io.Serializable;

public class Data implements Serializable {

    public String Name, Password;

    public Data() {
    }

    public Data(String name, String password) {

        Name = name;
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
