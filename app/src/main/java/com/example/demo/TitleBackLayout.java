package com.example.demo;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.ActionBar;

public class TitleBackLayout extends LinearLayout {
    public TitleBackLayout(Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        ImageView imageView = findViewById(R.id.back_btn);
        imageView.setOnClickListener(view -> {
            ((Activity)getContext()).finish();
        });
    }

}
