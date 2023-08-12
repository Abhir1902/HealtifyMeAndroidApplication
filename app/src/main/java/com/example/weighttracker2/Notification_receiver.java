package com.example.weighttracker2;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class Notification_receiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent)
    {

        NotificationManager notificationManager=(NotificationManager)  context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent repeating_intent = new Intent(context,WaterTrackerRepeating.class);
        repeating_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //Toast.makeText(context, "3", Toast.LENGTH_SHORT).show();
        PendingIntent pendingIntent = PendingIntent.getActivity(context,100,repeating_intent,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder= new NotificationCompat.Builder(context)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.water)
                .setContentTitle("TIME TO DRINK ANOTHER GLASS OF WATER !")
                .setContentText("Drinking a glass of water will take you one step closer to your goal")
                .setAutoCancel(true);

        notificationManager.notify(100,builder.build());

    }
}
