package com.ahmedsohail.i200557;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDAO {

    private DatabaseHelper dbHelper;

    public UserDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public long addUser(String username, String email, String password) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ChatContract.UserEntry.COLUMN_USERNAME, username);
        values.put(ChatContract.UserEntry.COLUMN_EMAIL, email);
        values.put(ChatContract.UserEntry.COLUMN_PASSWORD, password);

        return db.insert(ChatContract.UserEntry.TABLE_NAME, null, values);
    }

    public Cursor getAllUsers() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.query(
                ChatContract.UserEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    public Cursor getUserByEmail(String email) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {
                ChatContract.UserEntry._ID,
                ChatContract.UserEntry.COLUMN_USERNAME,
                ChatContract.UserEntry.COLUMN_EMAIL,
                ChatContract.UserEntry.COLUMN_PASSWORD
        };
        String selection = ChatContract.UserEntry.COLUMN_EMAIL + " = ?";
        String[] selectionArgs = {email};

        return db.query(
                ChatContract.UserEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
    }

    public int updateUserPassword(long userId, String newPassword) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ChatContract.UserEntry.COLUMN_PASSWORD, newPassword);

        return db.update(
                ChatContract.UserEntry.TABLE_NAME,
                values,
                ChatContract.UserEntry._ID + " = ?",
                new String[]{String.valueOf(userId)}
        );
    }

    public int deleteUser(long userId) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return db.delete(
                ChatContract.UserEntry.TABLE_NAME,
                ChatContract.UserEntry._ID + " = ?",
                new String[]{String.valueOf(userId)}
        );
    }

    // Other methods for user-related operations as needed
}
