package com.example.noor2.appointer;

import java.util.ArrayList;

public class User {
    private int ID;
    private String UserName;
    private String Password;
    private String PhoneNumber;
    private String Email;
    private String UserKind;
    private String Services;
    private Business BUSINESS;


    User(int Id, String u, String p, String ph, String e, String k, String s)
    {
        UserKind=k;
        Services=s;
        ID=Id;
        UserName=u;
        Password=p;
        PhoneNumber=ph;
        Email=e;
        BUSINESS = new Business(new ArrayList<Integer>() ,new ArrayList<Integer>(),"","",new ArrayList<com.example.noor2.appointer.Services>());
    }

    public Business getBUSINESS() {
        return BUSINESS;
    }

    public void setBUSINESS(Business BUSINESS) {
        this.BUSINESS = BUSINESS;
    }

    public String getServices() {
        return Services;
    }

    public void setServices(String services) {
        Services = services;
    }

    public String getUserKind() {
        return UserKind;
    }

    public void setUserKind(String userKind) {
        UserKind = userKind;
    }


    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
