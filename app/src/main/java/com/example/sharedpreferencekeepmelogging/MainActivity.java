package com.example.sharedpreferencekeepmelogging;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,password;
    Button login;

    SharedPreferences sharedPreferences;
    public static  final String fileName="MainFile";
    public static  final String UserName="LoginUserName";
    public static  final String Password="LoginPassword";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.id_2);
        password=findViewById(R.id.id_3);
        login=findViewById(R.id.login_button_id);
        sharedPreferences=getSharedPreferences(fileName, Context.MODE_PRIVATE);
        if (sharedPreferences.contains(UserName))
        {
            Intent intent=new Intent(MainActivity.this,Second.class);
            startActivity(intent);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name=name.getText().toString();
                String Pass=password.getText().toString();

                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putString(UserName,Name);
                editor.putString(Password,Pass);
                editor.commit();
                Toast.makeText(MainActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,Second.class);
                startActivity(intent);
                finish();


            }
        });

    }
}