package com.example.weighttracker2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Edit extends AppCompatActivity {

    TextView textView1;
    TextView textView24;
    TextView textView25;
    TextView textView26;
    TextView textView27;
    TextView textView28;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        textView1=findViewById(R.id.textView1);
        textView24=findViewById(R.id.textView24);
        textView25=findViewById(R.id.textView25);
        textView26=findViewById(R.id.textView26);
        textView27=findViewById(R.id.textView27);
        textView28=findViewById(R.id.textView28);

        String name=getIntent().getStringExtra("keyname");
        String age=getIntent().getStringExtra("keyage");
        String height=getIntent().getStringExtra("keyheight");
        String weight=getIntent().getStringExtra("keyweight");
        String gender=getIntent().getStringExtra("keygender");

        textView1.setText("Hi "+name+" \n YOUR HEALTH DETAILS - ");
        textView24.setText("NAME : "+name);
        textView25.setText("AGE : "+age+" YEARS");
        textView26.setText("HEIGHT : "+height+" CMS");
        textView27.setText("WEIGHT : "+weight+" KGS");
        textView28.setText("GENDER : "+gender);


    }
}