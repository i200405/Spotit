package com.ahmedsohail.i200557;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Calendar;

public class MessageDAO {

    private DatabaseHelper dbHelper;

    public MessageDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public long addMessage(int senderId, int receiverId, String messageContent, String messageType, String status) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ChatContract.MessageEntry.COLUMN_SENDER_ID, senderId);
        values.put(ChatContract.MessageEntry.COLUMN_RECEIVER_ID, receiverId);
        values.put(ChatContract.MessageEntry.COLUMN_MESSAGE_CONTENT, messageContent);
        values.put(ChatContract.MessageEntry.COLUMN_MESSAGE_TYPE, messageType);
        values.put(ChatContract.MessageEntry.COLUMN_STATUS, status);
        values.put(ChatContract.MessageEntry.COLUMN_TIMESTAMP, Calendar.getInstance().getTimeInMillis());

        return db.insert(ChatContract.MessageEntry.TABLE_NAME, null, values);
    }

    public Cursor getAllMessages() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.query(
                ChatContract.MessageEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }

    public Cursor getMessagesBySenderId(int senderId) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String[] projection = {
                ChatContract.MessageEntry._ID,
                ChatContract.MessageEntry.COLUMN_SENDER_ID,
                ChatContract.MessageEntry.COLUMN_RECEIVER_ID,
                ChatContract.MessageEntry.COLUMN_MESSAGE_CONTENT,
                ChatContract.MessageEntry.COLUMN_MESSAGE_TYPE,
                ChatContract.MessageEntry.COLUMN_STATUS,
                ChatContract.MessageEntry.COLUMN_TIMESTAMP
        };
        String selection = ChatContract.MessageEntry.COLUMN_SENDER_ID + " = ?";
        String[] selectionArgs = {String.valueOf(senderId)};

        return db.query(
                ChatContract.MessageEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
    }

    public int updateMessageStatus(long messageId, String newStatus) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ChatContract.MessageEntry.COLUMN_STATUS, newStatus);

        return db.update(
                ChatContract.MessageEntry.TABLE_NAME,
                values,
                ChatContract.MessageEntry._ID + " = ?",
                new String[]{String.valueOf(messageId)}
        );
    }

    public int deleteMessage(long messageId) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return db.delete(
                ChatContract.MessageEntry.TABLE_NAME,
                ChatContract.MessageEntry._ID + " = ?",
                new String[]{String.valueOf(messageId)}
        );
    }

    @SuppressLint("Range")
    public int deleteMessageIfWithinTimeLimit(long messageId, int timeLimitInMinutes) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        // Retrieve message timestamp
        Cursor cursor = db.query(
                ChatContract.MessageEntry.TABLE_NAME,
                new String[]{ChatContract.MessageEntry.COLUMN_TIMESTAMP},
                ChatContract.MessageEntry._ID + " = ?",
                new String[]{String.valueOf(messageId)},
                null,
                null,
                null
        );

        long messageTimestamp = 0;
        if (cursor != null && cursor.moveToFirst()) {
            messageTimestamp = cursor.getLong(cursor.getColumnIndex(ChatContract.MessageEntry.COLUMN_TIMESTAMP));
            cursor.close();
        }

        // Calculate time difference
        if (messageTimestamp > 0) {
            long currentTime = Calendar.getInstance().getTimeInMillis();
            long timeDifference = currentTime - messageTimestamp;

            // Convert time limit to milliseconds
            long timeLimitInMillis = timeLimitInMinutes * 60 * 1000;

            // Check if the time difference is within the allowed limit
            if (timeDifference <= timeLimitInMillis) {
                return db.delete(
                        ChatContract.MessageEntry.TABLE_NAME,
                        ChatContract.MessageEntry._ID + " = ?",
                        new String[]{String.valueOf(messageId)}
                );
            }
        }

        return -1;
    }


}

