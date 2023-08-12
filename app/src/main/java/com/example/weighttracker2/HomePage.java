package com.example.weighttracker2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.weighttracker2.data.MyDbHandler;

public class HomePage extends AppCompatActivity {

    ImageButton sleepTracker;
    ImageButton stepCounter;
    ImageButton bmi;
    ImageButton StepCounter;
    ImageButton waterTracker;
    ImageButton calorie;
    Button edit;
    ImageButton workout;
    String name;
    String age;
    String height;
    String weight;
    String gender;
    MyDbHandler db;
    TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        db = new MyDbHandler(HomePage.this);
        sleepTracker=findViewById(R.id.sleepTrackerbtn);
        stepCounter=findViewById(R.id.stepCounterbtn);
        bmi=findViewById(R.id.button4);
        StepCounter=findViewById(R.id.stepCounterbtn);
        waterTracker=findViewById(R.id.button5);
        workout=findViewById(R.id.workout);
        textView=findViewById(R.id.textView16);
        edit=findViewById(R.id.button7);
        calorie=findViewById(R.id.calorie);

        name=getIntent().getStringExtra("keyname");
        age=getIntent().getStringExtra("keyage");
        height=getIntent().getStringExtra("keyheight");
        weight=getIntent().getStringExtra("keyweight");
        gender=getIntent().getStringExtra("keygender");
        db.add(name.toString(),age.toString(),height.toString(),weight.toString(),gender.toString());
        textView.setText("Hi,"+name+" "+"\nAll the best for your fitness journey !");

        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(HomePage.this, BMICalculator.class);
                startActivity(intent);
            }
        });

        waterTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),WaterTrackerRepeating.class);
                startActivity(intent);

            }
        });

        StepCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(HomePage.this, StepCounter.class);
                startActivity(intent);
            }
        });

        sleepTracker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(HomePage.this, SleepTrackerAlarm.class);
                startActivity(intent);
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this, Edit.class);
                intent.putExtra("keyname",name);
                intent.putExtra("keyage",age);
                intent.putExtra("keyheight",height);
                intent.putExtra("keyweight",weight);
                intent.putExtra("keygender",gender);
                startActivity(intent);
            }
        });


        workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,WorkoutGuide.class);
                startActivity(intent);
            }
        });

        calorie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(HomePage.this,CalorieCounter.class);
                startActivity(intent);
            }
        });

    }
}