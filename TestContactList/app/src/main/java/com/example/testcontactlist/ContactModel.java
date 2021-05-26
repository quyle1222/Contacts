package com.example.testcontactlist;

import android.graphics.Bitmap;

public class ContactModel implements Comparable<ContactModel> {
    private String name;
    private String phone;
    private Bitmap avatar;

    public ContactModel(String name, String phone, Bitmap avatar) {
        this.name = name;
        this.phone = phone;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Bitmap getAvatar() {
        return avatar;
    }

    public void setAvatar(Bitmap avatar) {
        this.avatar = avatar;
    }


    @Override
    public int compareTo(ContactModel o) {
        return this.name.compareTo(o.name);
    }
}


