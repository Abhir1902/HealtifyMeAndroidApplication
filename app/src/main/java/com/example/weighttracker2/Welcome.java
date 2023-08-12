package com.example.weighttracker2;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

//thread is used to do more than one functionality at the same time
        Thread thread=new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                finally{
                    Intent intent=new Intent(Welcome.this, SignUp.class);
                    startActivity(intent);
                }
            }

        };
        thread.start();

    }
}