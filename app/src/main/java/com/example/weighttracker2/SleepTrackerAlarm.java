package com.example.weighttracker2;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SleepTrackerAlarm extends AppCompatActivity {
    static final int ALARM_REQ_CODE = 100;
    //EditText timing;
    Button set;
    Button stop;
    EditText sleepTime;
    EditText wakeUpTime;
    EditText editText;
    Button button;
    TextView show;
    MediaPlayer mp;

    //@SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_tracker_alarm);

        //timing=findViewById(R.id.edittext);
        set=findViewById(R.id.set);
        stop=findViewById(R.id.stop);
        sleepTime=findViewById(R.id.sleepTime);
        wakeUpTime=findViewById(R.id.wakeUpTime);
        editText=findViewById(R.id.edittext);
        button=findViewById(R.id.button6);
        show=findViewById(R.id.textView23);

        AlarmManager alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);
        //@SuppressLint({"MissingInflatedId", "LocalSuppress"})

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int time= Integer.parseInt(((EditText)(findViewById(R.id.edittext))).getText().toString());
                long triggerTime=System.currentTimeMillis()+(time * 1000);
                Intent iBroadcast =new Intent(SleepTrackerAlarm.this,MyReceiver.class);
                PendingIntent pi=PendingIntent.getBroadcast(SleepTrackerAlarm.this,ALARM_REQ_CODE,iBroadcast,PendingIntent.FLAG_MUTABLE );
                alarmManager.set(AlarmManager.RTC_WAKEUP,triggerTime,pi);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //alarmManager.cancel(iBroadcast);
                mp.pause();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str1 = sleepTime.getText().toString();
                String str2 = wakeUpTime.getText().toString();

//Get the user values from the widget reference
                int sleepTime = Integer.parseInt(str1);
                int wakeUpTime = Integer.parseInt(str2);

//Calculate BMI value
                int calculate_sleep = wakeUpTime - sleepTime;
                if(calculate_sleep<0)
                {
                    calculate_sleep=24+calculate_sleep;
                }
                show.setText("Your Sleep Duration is : "+String.valueOf(calculate_sleep));
            }
        });


    }
}
