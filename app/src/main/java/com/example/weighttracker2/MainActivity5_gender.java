package com.example.weighttracker2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5_gender extends AppCompatActivity {
    ImageButton imageButton;
    ImageButton imageButton2;
    Button next5;
    String click="none";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity5_gender);

        imageButton=(ImageButton) findViewById(R.id.imageButton);
        imageButton2=(ImageButton) findViewById(R.id.imageButton2);
        next5=findViewById(R.id.button3);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageButton.setImageResource(R.drawable.female2);
                click="female";
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageButton2.setImageResource(R.drawable.men2);
                click="men";
            }
        });

        next5.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(MainActivity5_gender.this, HomePage.class);
                        intent.putExtra("keyname",getIntent().getStringExtra("keyname"));
                        intent.putExtra("keyage",getIntent().getStringExtra("keyage"));
                        intent.putExtra("keyheight",getIntent().getStringExtra("keyheight"));
                        intent.putExtra("keyweight",getIntent().getStringExtra("keyweight"));
                        intent.putExtra("keygender",click);
                        startActivity(intent);
                    }
                }
        );
    }
}