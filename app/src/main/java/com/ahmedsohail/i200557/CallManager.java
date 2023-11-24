package com.ahmedsohail.i200557;

import com.sinch.android.rtc.calling.Call;
import com.sinch.android.rtc.calling.CallClient;

public class CallManager {

    private CallClient callClient;

    public CallManager(CallClient callClient) {
        this.callClient = callClient;
    }

    // Method to start an outgoing call
    public Call startOutgoingCall(String recipientUserId) {
        return callClient.callUser(recipientUserId);
    }

    // Method to end an ongoing call
    public void endCall(Call call) {
        if (call != null) {
            call.hangup();
        }
    }
}
