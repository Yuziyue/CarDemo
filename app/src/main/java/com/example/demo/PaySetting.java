package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PaySetting extends AppCompatActivity {
    private TextView title_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_setting);
        title_text = findViewById(R.id.title_text);
        title_text.setText("无感支付设置");
    }
}