package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.demo.adapter.AdFragment;

public class WithoutCarMain extends AppCompatActivity {


    private TextView textView;

    private AdFragment adFragment;

    private ImageView bindBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_without_car_main);
        textView = findViewById(R.id.title_text);
        bindBtn = findViewById(R.id.bind_btn);
        textView.setText("无感充电");
        initAdFrame(); //首次初始化 默认用户名登录方式



        bindBtn.setOnClickListener(view -> {
            String flag = "no";
            Intent intent = new Intent(WithoutCarMain.this,AddCar.class);
            intent.putExtra("flag",flag);
            startActivity(intent);
            finish();
        });

    }

    private void initAdFrame(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        if(loginFragment==null){
//            loginFragment = new LoginFragment();
//            transaction.add(R.id.login_frame_layout,loginFragment);
//        }
//        hideFragment(transaction);
//        transaction.show(loginFragment);


        if(adFragment==null){
            adFragment = new AdFragment();
        }
        transaction.replace(R.id.ad_frame_layout,adFragment);


        transaction.commit();
    }
}