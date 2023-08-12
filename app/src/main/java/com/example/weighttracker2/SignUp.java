package com.example.weighttracker2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    EditText username, password, confirmpassword;
    Button btnLogUp, btnSignIn;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        confirmpassword=(EditText)findViewById(R.id.confirmpassword);

        btnSignIn=(Button)findViewById(R.id.btnSignIn);
        btnLogUp=(Button)findViewById(R.id.btnLogIn);

        DB=new DBHelper(this);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                String conpass=confirmpassword.getText().toString();
                if(user.equals("")|| pass.equals("") || conpass.equals("")){
                    Toast.makeText(SignUp.this,"Fill all the fields",Toast.LENGTH_SHORT).show();

                }else{
                    if(pass.equals(conpass)){
                        Boolean userCheckResult= DB.checkusername(user);
                        if(userCheckResult==false){
                            Boolean regResult= DB.insertData(user,pass);
                            if(regResult==true){
                                Toast.makeText(SignUp.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),Login.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(SignUp.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }

                        }else{
                            Toast.makeText(SignUp.this, "User already Exist \n Please LogIn", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(SignUp.this, "Password doesn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnLogUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });

    }
}
