package com.example.weighttracker2;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class CalorieCounter extends AppCompatActivity {
    EditText name, cal;
    Button insert, update, delete, view, clear;
    DBCounter DB;
    String nameTXT="";
    String calTXT="";
    int total_cal=0;
    Button button_recipe,button_chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_counter);
        name = findViewById(R.id.name);
        cal = findViewById(R.id.cal);
        insert = findViewById(R.id.btnInsert);
        update = findViewById(R.id.btnUpdate);
        //delete = findViewById(R.id.btnDelete);
        view = findViewById(R.id.btnView);
        clear=findViewById(R.id.btnclear);
        button_chart=findViewById(R.id.button_chart);
        button_recipe=findViewById(R.id.button_recipe);
        DB = new DBCounter(this);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameTXT = name.getText().toString();
                calTXT = cal.getText().toString();
                total_cal+=Integer.parseInt((calTXT));

                Boolean checkinsertdata = DB.insertfooddata(nameTXT, calTXT);

                if(checkinsertdata==true)
                    Toast.makeText(CalorieCounter.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(CalorieCounter.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
            }        });


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String foodTXT = cal.getText().toString();

                Boolean checkupdatedata = DB.updatefooddata(nameTXT, foodTXT);
                if(checkupdatedata==true) {
                    total_cal-=Integer.parseInt((calTXT));
                    Toast.makeText(CalorieCounter.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                    total_cal += Integer.parseInt((calTXT));
                }
                else
                    Toast.makeText(CalorieCounter.this, "New Entry Not Updated", Toast.LENGTH_SHORT).show();
            }        });
       /* delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                Boolean checkdeletedata = DB.deletedata(nameTXT);
                if(checkdeletedata==true)
                    Toast.makeText(MainActivity.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
            }        });*/

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(CalorieCounter.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Food :"+res.getString(0)+"\n");
                    buffer.append("Calories :"+res.getString(1)+"\n\n");
                }
                buffer.append("Total Calories Consumed:"+total_cal);

                AlertDialog.Builder builder = new AlertDialog.Builder(CalorieCounter.this);
                builder.setCancelable(true);
                builder.setTitle("FOOD TRACKER");
                builder.setMessage(buffer.toString());
                builder.show();
            }        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText(null);
                cal.setText(null);
            }

        });





        button_chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), Chart.class);
                startActivity(intent1);
            }
        });


        button_recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(), Recipe.class);
                startActivity(intent2);
            }
        });


    }}

