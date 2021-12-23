package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class UserMain extends AppCompatActivity {


    private ImageView imageView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
        Intent intent1 = getIntent();
        String car_flag = intent1.getStringExtra("flag");
        button = findViewById(R.id.charge_btn);
        imageView= findViewById(R.id.back_main_img);
        button.setOnClickListener(view -> {
            if(car_flag.equals("no")){
                Intent intent = new Intent(UserMain.this,WithoutCarMain.class);
                startActivity(intent);
            }else if(car_flag.equals("yes")){
                Intent intent = new Intent(UserMain.this,WithCarMain.class);
                startActivity(intent);
                finish();
            }

        });

        imageView.setOnClickListener(view -> {
            finish();
        });
    }
}