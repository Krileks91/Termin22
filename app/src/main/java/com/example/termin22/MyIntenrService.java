package com.example.termin22;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;


import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;


public class MyIntenrService extends IntentService {

    public static final String TAG = "MyIntentService";
    public static final String MSG_TAG = "msg_tag";
    public static final int NOTIF_ID = 5;


    public MyIntenrService() {
        super(TAG);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        showNotifIfNeeded();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String msg = intent.getStringExtra(MSG_TAG);
        for (int i = 0; i < 10 ; i++) {
            SystemClock.sleep(1000);

            Log.e(TAG,msg + " : " + i);

        }
    }

    private void showNotifIfNeeded(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            Notification notification = new NotificationCompat.Builder(this, MyApp.CHANNEL_ID)
                    .setContentTitle("Our Intent Service")
                    .setContentText("Working smart, not hard")
                    .setSmallIcon(R.drawable.ic_baseline_confirmation_number_24)
                    .build();
            startForeground(NOTIF_ID, notification);
        }
    }
}
