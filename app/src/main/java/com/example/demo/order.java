package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.demo.adapter.MyAdapter;
import com.example.demo.adapter.orderInfo;

import java.util.ArrayList;
import java.util.List;

public class order extends AppCompatActivity {

    private MyAdapter adapter;
    List<orderInfo> mList = new ArrayList<>();


    private TextView title_text;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        title_text = findViewById(R.id.title_text);
        recyclerView = findViewById(R.id.card_list);
        recyclerView.setHasFixedSize(true);

//RecyclerView 需要一个layoutManager，也就是布局管理器
//布局管理器能确定RecyclerView内各个子视图（项目视图）的位置
//并能决定何时重新使用对用户已不可见的项目视图
//安卓为我们预先准备好了三种视图管理器：LinearLayoutManager、
//GridLayoutManager、StaggeredGridLayoutManager（详见文档）

//这里我们选择创建一个LinearLayoutManager
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//为RecyclerView对象指定我们创建得到的layoutManager
            recyclerView.setLayoutManager(layoutManager);
        //初始化mList
        initInfo();
//实例化MyAdapter并传入mList对象
        adapter = new MyAdapter(mList);
//为RecyclerView对象mRecyclerView设置adapter
        recyclerView.setAdapter(adapter);

        title_text.setText("历史订单");
    }

    private void initInfo() {

//        测试数据
        orderInfo element1 = new orderInfo("1376781999121347865","进行中","2021-11-28 08:26:20", "30", "45");
        mList.add(element1);
        orderInfo element2 = new orderInfo("1376781999121347866","已完成","2021-11-27 08:26:20", "100", "51");
        mList.add(element2);

    }

}