package com.example.weighttracker2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity4_weight extends AppCompatActivity {

    TextView textView;
    NumberPicker numberPicker;
    Button next4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity4_weight);

        textView=findViewById(R.id.textView12);
        numberPicker=findViewById(R.id.numberPicker);
        next4=(Button) findViewById(R.id.button);

        numberPicker.setMinValue(15);
        numberPicker.setMaxValue(170);
        numberPicker.setValue(50);
        textView.setText(String.format("Weight : %s kgs",numberPicker.getValue()));

        //This method will run everytime the user scrolls through the numbers
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                textView.setText(String.format("Weight : %s kgs",i1));
            }
        });

        String weight=Integer.toString(numberPicker.getValue());

        next4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(MainActivity4_weight.this, MainActivity5_gender.class);
                        intent.putExtra("keyweight",weight);
                        intent.putExtra("keyname",getIntent().getStringExtra("keyname"));
                        intent.putExtra("keyage",getIntent().getStringExtra("keyage"));
                        intent.putExtra("keyheight",getIntent().getStringExtra("keyheight"));
                        startActivity(intent);
                    }
                }
        );

    }


}
