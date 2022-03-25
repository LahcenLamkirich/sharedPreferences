package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences pref;
    Button btnSave, btnLoad;
    EditText email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Register Page", Toast.LENGTH_LONG).show();
        btnSave = findViewById(R.id.btnSave);
        btnLoad = findViewById(R.id.btnLoad);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);


        // when we clicked the save button
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pref = getSharedPreferences("mypref", MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();
                String user = email.getText().toString();
                String pass = password.getText().toString();
                edit.putString("email", user);
                edit.putString("pass", pass);
                edit.commit();
                email.setText("");
                password.setText("");
                Intent i = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(i);

            }
        });

        String emai = pref.getString("email","");
        if(emai != null){
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("mypref", MODE_PRIVATE);
                email.setText(pref.getString("email", ""));
                password.setText(pref.getString("pass", ""));
            }
        });
    }
}