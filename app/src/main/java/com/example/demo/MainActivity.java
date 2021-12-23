package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView userTXT;
    private TextView scanTXT;

    private LoginFragment loginFragment;
    private ScanFragment scanFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userTXT =findViewById(R.id.username_txt);
        scanTXT =findViewById(R.id.erweima_txt);
        userTXT.setOnClickListener(this);
        scanTXT.setOnClickListener(this);
        initUserFrame(); //首次初始化 默认用户名登录方式
//        loginBtn.setOnClickListener(view -> {
//            //Intent intent = new Intent(MainActivity.this,jumpWait.class);
//            //startActivity(intent);
//        });
    }

    private void initUserFrame(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        if(loginFragment==null){
//            loginFragment = new LoginFragment();
//            transaction.add(R.id.login_frame_layout,loginFragment);
//        }
//        hideFragment(transaction);
//        transaction.show(loginFragment);


        if(loginFragment==null){
            loginFragment = new LoginFragment();
        }
        transaction.replace(R.id.login_frame_layout,loginFragment);


        transaction.commit();
    }
    private void initScanFrame(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        if(scanFragment==null){
//            scanFragment = new ScanFragment();
//            transaction.add(R.id.login_frame_layout,scanFragment);
//        }
//        hideFragment(transaction);
//        transaction.show(scanFragment);

        if(scanFragment==null){
            scanFragment = new ScanFragment();
        }
        transaction.replace(R.id.login_frame_layout,scanFragment);

        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction){
        if(loginFragment!=null){
            transaction.hide(loginFragment);
        }
        if(scanFragment!=null){
            transaction.hide(scanFragment);
        }
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v){
        if(v== userTXT){
            userTXT.setTextSize(30);
            scanTXT.setTextSize(20);
            initUserFrame();
            //Toast.makeText(this, "ss", Toast.LENGTH_SHORT).show();
        }else if(v== scanTXT){
            scanTXT.setTextSize(30);
            userTXT.setTextSize(20);
            initScanFrame();
            //Toast.makeText(this, "aa", Toast.LENGTH_SHORT).show();
        }
    }

}