package com.example.weighttracker2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText username1, password1;
    Button btnlogin1;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username1 = (EditText) findViewById(R.id.usernameLogin);
        password1 = (EditText) findViewById(R.id.passwordLogin);
        btnlogin1 = (Button) findViewById(R.id.btn2LogIn);
        DB = new DBHelper(this);
        btnlogin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username1.getText().toString();
                String pass = password1.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(Login.this, "Please enter all feilds", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(Login.this, "Sign in successfull", Toast.LENGTH_SHORT).show();
                        Intent intentLogin  = new Intent(getApplicationContext(), MainActivity.class);
                        intentLogin.putExtra("User",user);
                        startActivity(intentLogin);
                    }else{
                        Toast.makeText(Login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}

