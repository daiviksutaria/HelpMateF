package com.example.helpmatef;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.SQLException;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "UserDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_USERS = "users";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASSWORD = "password";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT NOT NULL,"
                + COLUMN_EMAIL + " TEXT UNIQUE NOT NULL,"
                + COLUMN_PASSWORD + " TEXT NOT NULL)";
        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    // ✅ Register user with name, email, and password
    public boolean registerUser(String name, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Remove extra spaces
        name = name.trim();
        email = email.trim();
        password = password.trim();

        Log.d("DBHandler", "Saving User: Name = " + name + ", Email = " + email);

        Cursor cursor = db.query(TABLE_USERS, new String[]{COLUMN_ID},
                COLUMN_EMAIL + "=?", new String[]{email}, null, null, null);

        if (cursor.moveToFirst()) {
            cursor.close();
            db.close();
            Log.d("DBHandler", "User already exists: " + email);
            return false; // User already exists
        }
        cursor.close();

        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);  // ✅ Save the correct name
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PASSWORD, password);

        long result = db.insert(TABLE_USERS, null, values);
        db.close();

        Log.d("DBHandler", "User registered successfully: " + email);
        return result != -1;
    }


    // ✅ Authenticate user
    public boolean authenticateUser(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = db.query(TABLE_USERS, new String[]{COLUMN_ID},
                    COLUMN_EMAIL + "=? AND " + COLUMN_PASSWORD + "=?",
                    new String[]{email, password}, null, null, null);

            boolean isValid = cursor.moveToFirst();
            return isValid;
        } catch (SQLException e) {
            Log.e("DBHandler", "Error authenticating user: " + e.getMessage());
            return false;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }
    }

    // ✅ Retrieve user name
    public String getUserName(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        try {
            cursor = db.query(TABLE_USERS, new String[]{COLUMN_NAME},
                    COLUMN_EMAIL + "=?",
                    new String[]{email}, null, null, null);

            String name = "User";
            if (cursor.moveToFirst()) {
                name = cursor.getString(0);
            }
            return name;
        } catch (SQLException e) {
            Log.e("DBHandler", "Error getting user name: " + e.getMessage());
            return "User";
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }
    }

    // ✅ Retrieve user details safely

    public Map<String, String> getUserDetails(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Map<String, String> userDetails = new HashMap<>();

        Log.d("DBHandler", "Fetching user details for email: " + email);

        Cursor cursor = db.rawQuery("SELECT name, email FROM users WHERE email = ?", new String[]{email});

        if (cursor.moveToFirst()) {
            userDetails.put("name", cursor.getString(0)); // Get name
            userDetails.put("email", cursor.getString(1)); // Get email

            Log.d("DBHandler", "User found: " + userDetails);
        } else {
            Log.d("DBHandler", "User not found in database for email: " + email);
        }

        cursor.close();
        db.close();
        return userDetails;
    }

}