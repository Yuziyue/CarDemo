package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Authorization extends AppCompatActivity {

    private TextView agree_text;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        agree_text=findViewById(R.id.agree_text);
        button=findViewById(R.id.agree_btn);
        SpannableString spannableString = new SpannableString("《云闪付无感支付协议》");
        spannableString.setSpan(new ClickableSpan() {
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.RED);       //设置文件颜色
                ds.setUnderlineText(true);      //设置下划线
            }

            @Override
            public void onClick(View widget) {
                Toast.makeText(Authorization.this, "点击事件", Toast.LENGTH_SHORT)
                        .show();
            }
        }, 0, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        agree_text.setHighlightColor(Color.TRANSPARENT);
        agree_text.setText(spannableString);
        // 设置tv2为可点击状态
        agree_text.setMovementMethod(LinkMovementMethod.getInstance());

        button.setOnClickListener(view -> {
            String flag = "succeed";
            Intent intent = new Intent(Authorization.this,jumpWait.class);
            intent.putExtra("flag",flag);
            startActivity(intent);
        });

    }




}