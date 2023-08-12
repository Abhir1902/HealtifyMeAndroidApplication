package com.example.weighttracker2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name;
    Button next1;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.entername);
        next1=(Button) findViewById(R.id.button2);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        addName();
    }
    public void addName()
    {
        next1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String Name=name.getText().toString();
                        Intent intent =new Intent(MainActivity.this, MainActivity2_age.class);
                        intent.putExtra("keyname",Name);
                        startActivity(intent);
                    }
                }
        );
    }




//    //NEW CODE
//    ListView listView;
//    //NEW CODE
//    EditText name,age,height,weight,gender;
//    Button submit;
//    MyDbHandler db;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        db = new MyDbHandler(MainActivity.this);
//        name = (EditText) findViewById(R.id.name);
//        age = (EditText) findViewById(R.id.age);
//        height = (EditText) findViewById(R.id.height);
//        weight = (EditText) findViewById(R.id.weight);
//        gender = (EditText) findViewById(R.id.gender);
//        submit=(Button) findViewById(R.id.button);
//        addData();
//    }
//        public void addData()
//        {
//            submit.setOnClickListener(
//                    new View.OnClickListener() {
//                        @Override
//                        public void onClick(View view) {
//                            db.add(name.getText().toString(),
//                                    age.getText().toString(),
//                                    height.getText().toString(),
//                                    weight.getText().toString(),
//                                    gender.getText().toString());
//                        }
//                    }
//            );
//        }

//        // Creating a contact object for the db
//        Contact harry = new Contact();
//        harry.setPhone_number("9090909090");
//        harry.setName("Harry");
//
//        // Adding a contact to the db
//        db.addContact(harry);
//
//        // Creating a contact object for the db
//        Contact larry = new Contact();
//        larry.setPhone_number("9090459090");
//        larry.setName("Larry");
//
//        // Adding a contact to the db
//        db.addContact(larry);
//
//        // Creating a contact object for the db
//        Contact tehri = new Contact();
//        tehri.setPhone_number("9090675409");
//        tehri.setName("Tehri");
//
//        // Adding a contact to the db
//        db.addContact(tehri);
//        Log.d("dbharry", "Id for tehri and larry are successfully added to the db");
//
//
//        tehri.setId(6);
//        tehri.setName("Changed Tehri");
//        tehri.setPhone_number("0000000000");
//        int affectedRows = db.updateContact(tehri);
//
//        Log.d("dbharry", "No of affected rows are: " + affectedRows);
//
//        db.deleteContactById(1);
//        db.deleteContactById(12);
//        db.deleteContactById(5);

        //NEW CODE
//        ArrayList<String> contacts =new ArrayList<>();
//        //listView = findViewById(R.id.listView);
//        //NEW CODE
//
//        // Get all contacts
//        List<Contact> allContacts = db.getAllContacts();
//        for(Contact contact: allContacts){
//            Log.d("dbharry", "\nId: " + contact.getId() + "\n" +
//                    "Name: " + contact.getName() + "\n"+
//                    "Phone Number: " + contact.getPhone_number() + "\n" );
//
//            //NEW CODE
//        contacts.add(contact.getName()+" ( " + contact.getPhone_number()+" ) ");
//            //NEW CODE
//        }
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,contacts);
//        listView.setAdapter(arrayAdapter);
//        //Log.d("dbharry", "Bro you have "+ db.getCount()+ " contacts in your database");

}