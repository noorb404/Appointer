package com.example.noor2.appointer;

public class StaffMembers {
    private String Name;
    private int Image;
    private String Phone;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    StaffMembers(String name, String phone, int image)
    {
        this.Image=image;
        this.Name=name;
        this.Phone=phone;

    }

}
