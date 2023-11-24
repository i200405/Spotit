package com.ahmedsohail.i200557;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        // Called when a new token is generated or refreshed
        // Get updated InstanceID token and send it to your server
    }
}

