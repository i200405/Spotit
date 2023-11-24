package com.ahmedsohail.i200557;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // Handle received message here
        // Extract data from remoteMessage (title, body, etc.)
        // Display notification, update UI, etc.
    }

    @Override
    public void onNewToken(String token) {
        // Called when a new token is generated or refreshed
        // Send this token to your server to associate it with the user
        // Update user's FCM token in your backend database
    }
}
