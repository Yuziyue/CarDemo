package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dou361.dialogui.DialogUIUtils;
import com.dou361.dialogui.bean.BuildBean;

public class BindCard extends AppCompatActivity {

    private TextView title_txt;
    private Button bind_button;
    private TextView success_textView;
    private Button yes_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_card);
        title_txt = findViewById(R.id.title_text);
        bind_button = findViewById(R.id.bindCard_btn);
        title_txt.setText("绑定银行卡");

        bind_button.setOnClickListener(view -> {
            View rootView1 = View.inflate(BindCard.this,R.layout.auz_success,null);
            BuildBean bean = DialogUIUtils.showCustomAlert(this,rootView1, Gravity.CENTER,true,true);
            success_textView = rootView1.findViewById(R.id.success_txt);
            success_textView.setText("绑定成功");
            yes_btn=rootView1.findViewById(R.id.yes1_btn);
            bean.show();
            yes_btn.setOnClickListener(view1 -> {
                Intent intent = new Intent(BindCard.this,BankCard.class);
                startActivity(intent);
                finish();
            });

        });

    }
}