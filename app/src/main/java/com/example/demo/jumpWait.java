package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class jumpWait extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;

    private Button button;

    private  String flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump_wait);
        Intent intent1 = getIntent();
        flag = intent1.getStringExtra("flag");
        textView1 = findViewById(R.id.title_text);
        textView2 = findViewById(R.id.main_text);
        button = findViewById(R.id.jump_btn);
        if(flag.equals("login")){
            textView1.setText("页面跳转中");
            textView2.setText("登录成功");
        }
        else if(flag.equals("succeed")){
            textView1.setText("页面跳转中");
            textView2.setText("授权成功");
        }else if(flag.equals("bind")){
            textView1.setText("页面跳转中");
            textView2.setText("绑定成功");
        }

        button.setOnClickListener(view -> {
            if(flag.equals("login")){
              Intent intent = new Intent(jumpWait.this,UserMain.class);
              startActivity(intent);
            }else if(flag.equals("succeed")||flag.equals("bind")){
                Intent intent = new Intent(jumpWait.this,WithCarMain.class);
                startActivity(intent);
            }
        });
    }
}