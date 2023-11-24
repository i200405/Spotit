package com.ahmedsohail.i200557;

import android.provider.BaseColumns;

public final class ChatContract {

    public static class UserEntry implements BaseColumns {
        public static final String TABLE_NAME = "Users";
        public static final String COLUMN_USERNAME = "username";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_PASSWORD = "password";
        public static final String COLUMN_CREATED_AT = "created_at";
    }

    public static class MessageEntry implements BaseColumns {
        public static final String TABLE_NAME = "Messages";
        public static final String COLUMN_SENDER_ID = "sender_id";
        public static final String COLUMN_RECEIVER_ID = "receiver_id";
        public static final String COLUMN_MESSAGE_CONTENT = "message_content";
        public static final String COLUMN_MESSAGE_TYPE = "message_type";
        public static final String COLUMN_TIMESTAMP = "timestamp";
        public static final String COLUMN_STATUS = "status";
    }
}

