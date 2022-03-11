package com.example.sharedpreferencekeepmelogging;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Second extends AppCompatActivity {


   private SharedPreferences sharedPreferences;
    public static  final String fileName="MainFile";
    public static  final String UserName="LoginUserName";
    TextView n;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        n=findViewById(R.id.name_id);
        logout=findViewById(R.id.logout_id);


        sharedPreferences=getSharedPreferences(fileName, Context.MODE_PRIVATE);
        if (sharedPreferences.contains(UserName))
        {
           n.setText(sharedPreferences.getString(UserName,""));
        }
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
            }
        });
    }
}