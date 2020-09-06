package com.example.noor2.appointer;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Business {

    private ArrayList<Integer> Images;//HAIRCUTS
    private ArrayList<Integer> Products;
    private ArrayList<String> Customers;
    private ArrayList<StaffMembers> StaffMembers;
    private ArrayList<String> FreeTime;//FOR ORDER ACTIVITY
    private ArrayList<Services> ScheduleSeatsTaken;// FOR BUSINESS SCHEDULE.
    private ArrayList<Services> services;//FOR SERVICES.
    private Map<String,String> OpenHours;//FOR BUSINESS PROFILE DETAILS ACTIVITY
    private String ShopName;
    private String ShopLocation;
    private int ProfileImage;
    private int Rate;


    Business(ArrayList<Integer> images, ArrayList<Integer> products, String shopName, String shopLocation, ArrayList<Services> services) {
        Customers=new ArrayList<>();
        StaffMembers=new ArrayList<>();
        FreeTime=new ArrayList<>();
        ScheduleSeatsTaken=new ArrayList<>();
        OpenHours=new HashMap<>();
        Images = images;
        Products = products;
        ShopName = shopName;
        ShopLocation = shopLocation;
        this.services=services;
    }

    public int getRate() {
        return Rate;
    }

    public void setRate(int rate) {
        Rate = rate;
    }
    public int getProfileImage() {
        return ProfileImage;
    }

    public void setProfileImage(int profileImage) {
        ProfileImage = profileImage;
    }

    public ArrayList<String> getFreeTime() {
        return FreeTime;
    }

    public void setFreeTime(ArrayList<String> freeTime) {
        FreeTime = freeTime;
    }

    public ArrayList<StaffMembers> getStaffMembers() {
        return StaffMembers;
    }

    public void setStaffMembers(ArrayList<StaffMembers> staffMembers) {
        StaffMembers = staffMembers;
    }

    public ArrayList<String> getCustomers() {
        return Customers;
    }

    public void setCustomers(ArrayList<String> customers) {
        Customers = customers;
    }

    public ArrayList<Integer> getImages() {
        return Images;
    }

    public void setImages(ArrayList<Integer> images) {
        Images = images;
    }

    public ArrayList<Integer> getProducts() {
        return Products;
    }

    public void setProducts(ArrayList<Integer> products) {
        Products = products;
    }

    public String getShopName() {
        return ShopName;
    }

    public void setShopName(String shopName) {
        ShopName = shopName;
    }

    public String getShopLocation() {
        return ShopLocation;
    }

    public void setShopLocation(String shopLocation) {
        ShopLocation = shopLocation;
    }

    public ArrayList<Services> getScheduleSeatsTaken() {
        return ScheduleSeatsTaken;
    }
    public void setScheduleSeatsTaken(ArrayList<Services> scheduleSeatsTaken) {
        ScheduleSeatsTaken = scheduleSeatsTaken;
    }

    public Map<String, String> getOpenHours() {
        return OpenHours;
    }

    public void setOpenHours(Map<String, String> openHours) {
        OpenHours = openHours;
    }

    public ArrayList<Services> getServices() {
        return services;
    }

    public void setServices(ArrayList<Services> services) {
        this.services = services;
    }
}
