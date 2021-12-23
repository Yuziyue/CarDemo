package com.example.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demo.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.HashMap;
import java.util.List;

public class ListMenberBankcardAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<HashMap<String,Object>> mEntityList;
    public MyItemClickListener listener;

    public ListMenberBankcardAdapter(Context mContext, List<HashMap<String,Object>> mEntityList) {
        this.mContext = mContext;
        this.mEntityList = mEntityList;
    }

    @NonNull
    @Override
    public DemoViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_menber_bankcard, parent, false);
        DemoViewHolder viewHolder = new DemoViewHolder(view,listener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        /*BaseEntity entity = mEntityList.get(position);*/
       // ((DemoViewHolder) holder).ivMemberForm.setBackgroundResource(R.mipmap.bank_jianhang);
        ((DemoViewHolder) holder).ivMemberForm.setBackgroundResource((Integer) mEntityList.get(position).get("imgid"));
        ((DemoViewHolder) holder).tvMemberBankname.setText(mEntityList.get(position).get("bandname").toString());
        ((DemoViewHolder) holder).tvMemberBankfrom.setText(mEntityList.get(position).get("bankfrom").toString());
        ((DemoViewHolder) holder).tvMemberMantissa.setText(mEntityList.get(position).get("mantissa").toString());

        if (position%2==0){
            ((DemoViewHolder) holder).cvBankcard.setCardBackgroundColor(((DemoViewHolder) holder).color);
        }
    }
    public void setOnItemClickListener(MyItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return mEntityList.size();
    }
    private class DemoViewHolder extends RecyclerView.ViewHolder{

        private RoundedImageView ivMemberForm;
        private TextView tvMemberBankname;
        private TextView tvMemberBankfrom;
        private TextView tvMemberMantissa;
        private CardView cvBankcard;
        MyItemClickListener mListener;
        private int color;
        public DemoViewHolder(View view,final MyItemClickListener mListener) {
            super(view);
            ivMemberForm = (RoundedImageView) view.findViewById(R.id.iv_member_form);
            tvMemberBankname = (TextView) view.findViewById(R.id.tv_member_bankname);
            tvMemberBankfrom = (TextView) view.findViewById(R.id.tv_member_bankfrom);
            tvMemberMantissa = (TextView) view.findViewById(R.id.tv_member_mantissa);
            cvBankcard=view.findViewById(R.id.cv_bankcard);
            color=view.getResources().getColor(R.color.light_blue_900);
            view.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mListener.onItemClick(v, getAdapterPosition());
                        }

            });
        }
    }

    public interface  MyItemClickListener{
        void onItemClick(View view,int postion);
    }

}
