package com.example.weighttracker2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity2_age extends AppCompatActivity {
    TextView textView;
    NumberPicker numberPicker;
    Button next2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2_age);

        textView=findViewById(R.id.textView2);
        numberPicker=findViewById(R.id.numberPicker);
        next2=(Button) findViewById(R.id.next2);

        numberPicker.setMinValue(5);
        numberPicker.setMaxValue(112);
        numberPicker.setValue(20);
        textView.setText(String.format("Age : %s Years",numberPicker.getValue()));

        //This method will run everytime the user scrolls through the numbers
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                textView.setText(String.format("Age : %s Years",i1));
            }
        });

        String age=Integer.toString(numberPicker.getValue());


        next2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(MainActivity2_age.this, MainActivity3_height.class);
                        intent.putExtra("keyage",age);
                        intent.putExtra("keyname",getIntent().getStringExtra("keyname"));
                        startActivity(intent);
                    }
                }
        );


    }
}