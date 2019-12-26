package com.example.classassessment.model;

import java.io.Serializable;

public class User implements Serializable {

    //property
    private String name;
    private String gender;
    private String country;
    private String dob;
    private String email;
    private String phone;

    //methods
    public User(String name, String gender, String country, String dob, String email, String phone) {
        this.name = name;
        this.gender = gender;
        this.country = country;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
    }


    //behavior
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
