package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    SharedPreferences pref ;
    TextView email, password ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        email = findViewById(R.id.emailTxtView);
        password = findViewById(R.id.passwordTxtView);

        // when we enter to the seconde Activity:
        SharedPreferences pref = getSharedPreferences("mypref", MODE_PRIVATE);
        email.setText(pref.getString("email", ""));
        password.setText(pref.getString("pass", ""));
    }
}