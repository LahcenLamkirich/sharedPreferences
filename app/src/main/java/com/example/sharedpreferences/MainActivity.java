package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    SharedPreferences pref;
    Button btnSave, btnLoad;
    EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        // when we clicked the save button
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pref = getSharedPreferences("mypref", MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();
                String user = username.getText().toString();
                String pass = password.getText().toString();
                edit.putString("user", user);
                edit.putString("pass", pass);
                edit.commit();
                username.setText("");
                password.setText("");
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("mypref", MODE_PRIVATE);
                username.setText(pref.getString("user", ""));
                password.setText(pref.getString("pass", ""));
            }
        });
    }
}