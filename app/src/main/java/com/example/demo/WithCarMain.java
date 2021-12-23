package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.demo.adapter.AdFragment;

public class WithCarMain extends AppCompatActivity {


    private AdFragment adFragment;

    private ImageView imageView;
    private ImageView back_img;

    private Button charge_button;
    private Button order_button;
    private Button bank_button;
    private Button setting_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_car_main);
        imageView = findViewById(R.id.car);
        charge_button = findViewById(R.id.charge_btn);
        order_button = findViewById(R.id.order_btn);
        bank_button = findViewById(R.id.bank_btn);
        setting_button = findViewById(R.id.setting_btn);
        back_img = findViewById(R.id.back_btn);

        initAdFrame(); //首次初始化 默认用户名登录方式

        imageView.setOnClickListener(view -> {
            String flag = "yes";
            Intent car_intent = new Intent(WithCarMain.this,AddCar.class);
            car_intent.putExtra("flag",flag);
            startActivity(car_intent);
        });

        charge_button.setOnClickListener(view -> {
            Intent charge_intent = new Intent(WithCarMain.this,charge.class);
            startActivity(charge_intent);
        });

        order_button.setOnClickListener(v->{
            Intent order_intent = new Intent(WithCarMain.this,order.class);
            startActivity(order_intent);
        });

        bank_button.setOnClickListener(view -> {
            Intent bank_intent = new Intent(WithCarMain.this,BankCard.class);
            startActivity(bank_intent);
        });

        setting_button.setOnClickListener(view -> {
            Intent setting_intent = new Intent(WithCarMain.this,PaySetting.class);
            startActivity(setting_intent);
        });
        back_img.setOnClickListener(view -> {
            String flag = "yes";
            Intent intent = new Intent(WithCarMain.this,UserMain.class);
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