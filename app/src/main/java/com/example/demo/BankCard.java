package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.demo.adapter.ListMenberBankcardAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BankCard extends AppCompatActivity {

    private TextView title_textView;

    private RecyclerView recyclerView;

    private LinearLayout linearLayout;

    private ImageView bankpic;
    private TextView bankname;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_card);
        title_textView = findViewById(R.id.title_text);
        recyclerView = findViewById(R.id.rv_02_bankcard);
        bankpic = findViewById(R.id.bank_pic);
        bankname = findViewById(R.id.bankname);
        linearLayout = findViewById(R.id.showCard);
        button = findViewById(R.id.Bind_Btn);
        title_textView.setText("我的银行卡");


        final List<HashMap<String,Object>> listbank=new ArrayList<>();
        HashMap<String,Object> hashM=new HashMap<>();
        int bankid1 = getResource("bank_jianhang");
        hashM.put("imgid",bankid1);
        hashM.put("bandname","建设银行");
        hashM.put("bankfrom","储蓄卡");
        hashM.put("mantissa","3266");
        listbank.add(hashM);
        HashMap<String,Object> hashM1=new HashMap<>();
        int bankid2 = getResource("bank_youzheng");
        hashM1.put("imgid",bankid2);
        hashM1.put("bandname","邮政银行");
        hashM1.put("bankfrom","储蓄卡");
        hashM1.put("mantissa","3266");
        listbank.add(hashM1);
        HashMap<String,Object> hashM2=new HashMap<>();
        int bankid3 = getResource("bank_nongye");
        hashM2.put("imgid",bankid3);
        hashM2.put("bandname","农业银行");
        hashM2.put("bankfrom","储蓄卡");
        hashM2.put("mantissa","3266");
        listbank.add(hashM2);

        // 定义一个线性布局管理器
        LinearLayoutManager manager = new LinearLayoutManager(this);
        // 设置布局管理器
        recyclerView.setLayoutManager(manager);
        //初始化适配器 传入参数，context，listbank→数据源
        ListMenberBankcardAdapter adapter1=new ListMenberBankcardAdapter(this,listbank);
        recyclerView.setAdapter(adapter1);
        adapter1.setOnItemClickListener(new ListMenberBankcardAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
               // bankpic.setVisibility(View.INVISIBLE);
                bankpic.setImageResource((Integer) listbank.get(position).get("imgid"));
                bankname.setText(listbank.get(position).get("bandname").toString());
                if (position%2==0){
                    linearLayout.setBackgroundColor(Color.parseColor("#FF01579B"));
                }else{
                    linearLayout.setBackgroundColor(Color.parseColor("#87CEFA"));

                }
            }
        });
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                if (parent.getChildPosition(view) != (listbank.size() - 1)) {
                    outRect.bottom = -330;
                }
            }
        });

        button.setOnClickListener(view -> {
            Intent intent = new Intent(BankCard.this,BindCard.class);
            startActivity(intent);
            finish();
        });


    }

    public int  getResource(String bankname){
        Context ctx=getBaseContext();
        int resId = getResources().getIdentifier(bankname, "mipmap", ctx.getPackageName());
        //如果没有在"mipmap"下找到imageName,将会返回0
        return resId;
    }

}
