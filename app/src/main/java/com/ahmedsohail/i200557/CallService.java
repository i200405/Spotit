package com.ahmedsohail.i200557;

import android.content.Context;
import android.util.Log;
import com.sinch.android.rtc.SinchClient;
import com.sinch.android.rtc.calling.CallClient;
import com.sinch.android.rtc.calling.CallListener;
import com.sinch.android.rtc.calling.Call;

public class CallService {

    private static final String TAG = "CallService";
    private SinchClient sinchClient;
    private CallClient callClient;

    public CallService(Context context, SinchClient sinchClient) {
        this.sinchClient = sinchClient;
        callClient = sinchClient.getCallClient();
        setupCallListener();
    }

    // Method to set up call listener for incoming calls
    private void setupCallListener() {
        callClient.addCallClientListener(new CallClientListener() {
            @Override
            public void onIncomingCall(CallClient callClient, Call incomingCall) {
                Log.d(TAG, "Incoming call");
                // Handle incoming call here
                // For example, show incoming call notification, etc.
            }
        });
    }
}

