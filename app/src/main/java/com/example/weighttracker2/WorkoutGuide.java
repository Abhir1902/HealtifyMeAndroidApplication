package com.example.weighttracker2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class WorkoutGuide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_guide);

        ImageView work=(ImageView) findViewById(R.id.imageWork);
        ImageView med=(ImageView) findViewById(R.id.imageMeditate);
        ImageView run=(ImageView) findViewById(R.id.imageRun);


        work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url1="https://www.youtube.com/watch?v=ml6cT4AZdqI";
                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(url1));
                startActivity(intent1);
            }
        } );

        med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url2="https://www.youtube.com/watch?v=inpok4MKVLM";
                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(url2));
                startActivity(intent2);
            }
        } );

        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url3="https://www.youtube.com/watch?v=N9C88z3g0Es";
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse(url3));
                startActivity(intent3);
            }
        } );

    }
}
