package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.web.ChargeInfo;

public class FirstActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        button = findViewById(R.id.usernameLogin_btn);
        textView = findViewById(R.id.erweimadenglu_text);



        button.setOnClickListener(v->{



            Intent intent = new Intent(FirstActivity.this,MainActivity.class);
            startActivity(intent);

           // JSONObject data = ChargeInfo.post("http://36.154.37.114:8082/web/plug");
          //   String data = ChargeInfo.post("http://36.154.37.114:8082/web/plug");
            //if(data != null)
               // System.out.println(data.get("step"));
                //System.out.println(data);
          //  Toast.makeText(this, data+"aa", Toast.LENGTH_SHORT).show();

        });
    }




}