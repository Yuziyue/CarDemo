package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class LoginWait extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_wait);
        button = findViewById(R.id.loginWait_btn);

        button.setOnClickListener(v->{
            Intent intent = new Intent(LoginWait.this,UserMain.class);
            String flag = "no";
            intent.putExtra("flag",flag);
            startActivity(intent);
            finish();
        });
    }
}