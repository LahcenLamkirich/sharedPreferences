package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SharedPreferences pref;
    EditText username ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // when we clicked the save button
        pref = getSharedPreferences("mypref", MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        username = findViewById(R.id.username);
        String user = username.getText().toString();
        edit.putString("data", user);
        edit.commit();



    }
}