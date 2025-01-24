package com.example.csp.model;

import android.content.ContentValues;

public class Password {
    //Fields to hold website, username, and password
    private String website;
    private String username;
    private String password;
    //Constructor to initialize the Password object with website, username, and password
    public Password(String website, String username, String password) {
        this.website = website;
        this.username = username;
        this.password = password;
    }
    // Methods for retrieving the values of each field
    public String getWebsite() {
        return website;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    // Method to convert the Password object into ContentValues for use in database
    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();
        values.put("website", website);
        values.put("username", username);
        values.put("password", password);
        return values;
    }
}
