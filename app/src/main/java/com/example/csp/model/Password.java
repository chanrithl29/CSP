package com.example.csp.model;

import android.content.ContentValues;

public class Password {

    private String website;
    private String username;
    private String password;

    public Password(String website, String username, String password) {
        this.website = website;
        this.username = username;
        this.password = password;
    }

    public String getWebsite() {
        return website;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();
        values.put("website", website);
        values.put("username", username);
        values.put("password", password);
        return values;
    }
}
