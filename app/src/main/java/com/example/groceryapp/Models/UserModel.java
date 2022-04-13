package com.example.groceryapp.Models;

public class UserModel {
    String name;
    String ph_number;

    public UserModel() {
    }

    public UserModel(String name, String ph_number) {
        this.name = name;
        this.ph_number = ph_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPh_number() {
        return ph_number;
    }

    public void setPh_number(String ph_number) {
        this.ph_number = ph_number;
    }
}
