package com.example.csp.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class PasswordDatabase extends SQLiteOpenHelper {
    // Database information
    private static final String DATABASE_NAME = "passwords.db";
    private static final int DATABASE_VERSION = 1;
    // Table and column names
    private static final String TABLE_PASSWORDS = "passwords";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_WEBSITE = "website";
    private static final String COLUMN_USERNAME = "username";
    private static final String COLUMN_PASSWORD = "password";
    // Constructor to initialize the database
    public PasswordDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    // Methods for creating and upgrading the database
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the passwords table
        String createTableQuery = "CREATE TABLE " + TABLE_PASSWORDS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_WEBSITE + " TEXT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_PASSWORD + " TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop the old table and create a new one
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PASSWORDS);
        onCreate(db);
    }


    // Helper method to convert a Password object into ContentValues
    private ContentValues getContentValues(Password password) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_WEBSITE, password.getWebsite());
        values.put(COLUMN_USERNAME, password.getUsername());
        values.put(COLUMN_PASSWORD, password.getPassword());
        return values;
    }
    // Method to insert a Password object into the database
    public boolean insert(Password password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = this.getContentValues(password);
        long result = db.insert(TABLE_PASSWORDS, null, values);
        db.close();
        return result != -1;

    }
    // Method to retrieve all Password objects from the database
    public List<Password> getAllPasswords() {
        List<Password> passwords = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_PASSWORDS, null);

        if (cursor.moveToFirst()) {
            do {
                String website = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_WEBSITE));
                String username = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_USERNAME));
                String password = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_PASSWORD));
                passwords.add(new Password(website, username, password));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return passwords;
    }

}

