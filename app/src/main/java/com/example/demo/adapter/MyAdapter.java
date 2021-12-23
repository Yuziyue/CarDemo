package com.example.demo.adapter;

import static com.example.demo.adapter.orderInfo.AMOUNT_PREFIX;
import static com.example.demo.adapter.orderInfo.LEVEL_PREFIX;
import static com.example.demo.adapter.orderInfo.NO_PREFIX;
import static com.example.demo.adapter.orderInfo.STATUS_PREFIX;
import static com.example.demo.adapter.orderInfo.TIME_PREFIX;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;
import com.example.demo.order_detail;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.ContactViewHolder>{
    //MyAdapter的成员变量contactInfoList, 这里被我们用作数据的来源
    private List<orderInfo> contactInfoList;

    private Context context;
    //MyAdapter的构造器
    public MyAdapter(List<orderInfo> contactInfoList) {
        this.contactInfoList = contactInfoList;
    }
    //重写3个抽象方法
//onCreateViewHolder()方法 返回我们自定义的 ContactViewHolder对象
    @Override
    public ContactViewHolder onCreateViewHolder
    (ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.card_view,parent,false);

        final ContactViewHolder contactViewHolder = new ContactViewHolder(itemView);
        contactViewHolder.cardView.setOnClickListener(view -> {
         //   int position = contactViewHolder.getAdapterPosition();
         //   orderInfo order_pos = contactInfoList.get(position);
            Intent intent = new Intent(parent.getContext(), order_detail.class);
            parent.getContext().startActivity(intent);
        });

        return new ContactViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder
            (ContactViewHolder holder, int position) {

//contactInfoList中包含的都是ContactInfo类的对象
//通过其get()方法可以获得其中的对象
        orderInfo ci = contactInfoList.get(position);

//将viewholder中hold住的各个view与数据源进行绑定(bind)
        holder.order_no.setText(NO_PREFIX+ci.order_no);
        if(ci.order_status.equals("进行中")){
            holder.order_status.setTextColor(Color.GREEN);
            holder.order_amount.setTextColor(Color.RED);
            holder.yuan.setTextColor(Color.RED);
        }
        holder.order_status.setText(STATUS_PREFIX+ci.order_status);
        holder.order_time.setText(TIME_PREFIX+ci.order_time);
        holder.charge_level.setText(LEVEL_PREFIX+ci.charge_level);
        holder.order_amount.setText(AMOUNT_PREFIX+ci.order_amount);
    }

    //此方法返回列表项的数目
    @Override
    public int getItemCount() {
        return contactInfoList.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder {
        //create the viewHolder class

        CardView cardView;

        protected TextView order_no;
        protected TextView order_status;
        protected TextView order_time;
        protected TextView charge_level;
        protected TextView order_amount;
        protected TextView yuan;

        public ContactViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            order_no = itemView.findViewById(R.id.order_no);
            order_status = itemView.findViewById(R.id.order_status);
            order_time = itemView.findViewById(R.id.order_time);
            charge_level = itemView.findViewById(R.id.charge_level);
            order_amount = itemView.findViewById(R.id.order_amount);
            yuan = itemView.findViewById(R.id.yuan);
        }

    }


}
