package com.example.demo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dou361.dialogui.DialogUIUtils;
import com.dou361.dialogui.bean.BuildBean;

public class AddCar extends AppCompatActivity {

    private TextView titleText;
    private TextView pinText;
    private TextView typeText;

    private ImageView imageView;
    private ImageView back_img;

    private Button button;
    private Button agree_btn;
    private Button yes_btn;

    private TextView agree_text;


    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        Intent intent1 = getIntent();
        String car_flag = intent1.getStringExtra("flag");



        titleText = findViewById(R.id.title_text);
        pinText = findViewById(R.id.pin_text);
        typeText = findViewById(R.id.type_text);
        imageView = findViewById(R.id.close_img);
        back_img = findViewById(R.id.back_btn);


        button = findViewById(R.id.auz_btn);

        if(car_flag.equals("no")){
            titleText.setText("添加车辆");
            imageView.setVisibility(View.INVISIBLE);

        }
        else if(car_flag.equals("yes")){
            titleText.setText("我的车辆");
            button.setVisibility(View.GONE);
            titleText.setText("我的车辆");
            button.setText("开通无感支付");
            pinText.setText("12345678912");
            typeText.setText("比亚迪迪秦2017款");
            imageView.setImageResource(R.mipmap.open_);
            //imageView.setImageResource(R.drawable.e);
        }

        button.setOnClickListener(view -> {
            switch (flag){
                case 0:
                    titleText.setText("我的车辆");
                    button.setText("开通无感支付");
                    pinText.setText("12345678912");
                    typeText.setText("比亚迪迪秦2017款");
                    imageView.setVisibility(View.VISIBLE);
                    //   imageView.setImageResource(R.drawable.e);
                    flag=1;
                    break;
                case 1:
//                    Intent intent = new Intent(AddCar.this,Authorization.class);
//                    startActivity(intent);
                    View rootView = View.inflate(AddCar.this,R.layout.open_yun,null);
                   BuildBean bean1 =  DialogUIUtils.showCustomAlert(this,rootView, Gravity.CENTER,true,true);


                   //显示“开通无感充电支付”弹窗
                    bean1.show();
                    agree_text = rootView.findViewById(R.id.agree1_text);
                    agree_btn = rootView.findViewById(R.id.auz_btn);
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
                            Toast.makeText(AddCar.this, "点击事件", Toast.LENGTH_SHORT)
                                    .show();
                        }
                    }, 0, 11, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    agree_text.setHighlightColor(Color.TRANSPARENT);
                    agree_text.setText(spannableString);
                    // 设置tv2为可点击状态
                    agree_text.setMovementMethod(LinkMovementMethod.getInstance());
                    agree_btn.setOnClickListener(view1 -> {
                        View rootView1 = View.inflate(AddCar.this,R.layout.auz_success,null);
                        BuildBean bean = DialogUIUtils.showCustomAlert(this,rootView1,Gravity.CENTER,true,true);
                        DialogUIUtils.dismiss(bean1);
                        //显示“授权成功”弹窗
                        bean.show();
                     //   DialogUIUtils.showCustomAlert(this,rootView1, Gravity.CENTER,true,true).show();
                        yes_btn = rootView1.findViewById(R.id.yes1_btn);
                        yes_btn.setOnClickListener(view2 -> {
                            imageView.setImageResource(R.mipmap.open_);
                            DialogUIUtils.dismiss(bean);
                            button.setVisibility(View.GONE);
                            //改变标题栏的返回功能
                            back_img.setOnClickListener(view3 -> {
                                Intent intent = new Intent(AddCar.this,WithCarMain.class);
                                startActivity(intent);
                                finish();
                            });
                        });
                    });



            }

        });



    }
}