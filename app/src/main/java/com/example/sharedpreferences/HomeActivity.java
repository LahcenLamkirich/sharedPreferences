package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    SharedPreferences pref ;
    TextView email, password ;
    Button logOut ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toast.makeText(HomeActivity.this,"Logged Successfully !", Toast.LENGTH_SHORT).show();
        email = findViewById(R.id.emailTxtView);
        password = findViewById(R.id.passwordTxtView);
        logOut = findViewById(R.id.logOut);
        // when we enter to the seconde Activity:
        SharedPreferences pref = getSharedPreferences("mypref", MODE_PRIVATE);
        email.setText(pref.getString("email", ""));
        password.setText(pref.getString("pass", ""));

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor edit = pref.edit();
                edit.clear();
                edit.commit();
                Toast.makeText(HomeActivity.this, "Log Out Succesfully", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}