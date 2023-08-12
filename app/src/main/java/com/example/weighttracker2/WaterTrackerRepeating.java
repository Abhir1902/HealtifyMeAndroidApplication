package com.example.weighttracker2;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class WaterTrackerRepeating extends AppCompatActivity {

    private ProgressBar pbar;
    private static int a = 0;
    private TextView textView;
    private Handler handler = new Handler();
    @SuppressLint("MissingInflatedId")


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_tracker_repeating);

        textView = findViewById(R.id.textView18);
        pbar = findViewById(R.id.progressBar);
        pbar.setProgress(a);
        Button button = findViewById(R.id.plus);
        Button button1;
        button1 = findViewById(R.id.minus);
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,11);
        calendar.set(Calendar.MINUTE,41);
        calendar.set(Calendar.SECOND,30);
        Intent intent=new Intent(getApplicationContext(),Notification_receiver.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);
        // alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);
        // alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, 1000 * 60 * 20, alarmIntent);
        // PendingIntent alarmIntent;
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                1000 * 60 * 1, pendingIntent);


        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                new Thread(new Runnable() {
                    public void run() {
                        if (a < 12) {
                            a += 1;
                            handler.post(new Runnable() {
                                public void run() {
                                    pbar.setProgress(a);
                                    textView.setText(a + "/" + pbar.getMax());
                                    if (a == 12)
                                        textView.setText(" Your Progess has been Completed");
                                }
                            });
                            try {
                                // Sleep for 50 ms to show progress you can change it as well.
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }).start();
            }

        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //a = pbar.getProgress();
                new Thread(new Runnable() {
                    public void run() {
                        if (a >0) {
                            a -= 1;
                            handler.post(new Runnable() {
                                public void run() {
                                    pbar.setProgress(a);
                                    textView.setText(a + "/" + pbar.getMax());
                                    if (a == 12)
                                        textView.setText(" Your Progess has been Completed");
                                }
                            });
                            try {
                                // Sleep for 50 ms to show progress you can change it as well.
                                Thread.sleep(50);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }).start();


            }
        });


    }
}
