package com.example.weighttracker2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity3_height extends AppCompatActivity {

    TextView textView;
    NumberPicker numberPicker;
    Button next3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3_height);

        textView=findViewById(R.id.textView9);
        numberPicker=findViewById(R.id.numberPicker);
        next3=(Button) findViewById(R.id.next3);

        numberPicker.setMinValue(30);
        numberPicker.setMaxValue(260);
        numberPicker.setValue(150);
        textView.setText(String.format("Height : %s cms",numberPicker.getValue()));

        //This method will run everytime the user scrolls through the numbers
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                textView.setText(String.format("Height : %s cms",i1));
            }
        });

        String height=Integer.toString(numberPicker.getValue());

        next3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(MainActivity3_height.this, MainActivity4_weight.class);
                        intent.putExtra("keyheight",height);
                        intent.putExtra("keyname",getIntent().getStringExtra("keyname"));
                        intent.putExtra("keyage",getIntent().getStringExtra("keyage"));
                        startActivity(intent);
                    }
                }
        );

    }
}





