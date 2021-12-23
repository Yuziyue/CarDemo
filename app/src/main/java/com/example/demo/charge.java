package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.view.BatteryView;
import com.example.demo.web.ChargeInfo;

public class charge extends AppCompatActivity {

    private TextView title_text;
    private BatteryView horizontalBattery;
    private TextView battery_num;
    private TextView voltage_txt;
    private TextView current_txt;
    private TextView duration_txt;
    private TextView fee_txt;
    private ImageView battery_status;
    private TextView status_txt;
    private LinearLayout linearLayout;
    private int power=0;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    linearLayout.setVisibility(View.VISIBLE);
                    status_txt.setText("正常");
                    String str1 = msg.getData().getString("percent");
                    String str2 = msg.getData().getString("voltage");
                    String str3 = msg.getData().getString("current");
                    String str4 = msg.getData().getString("duration");
                    String str5 = msg.getData().getString("fee");
                    int dianliang = Integer.parseInt(str1);
                    String time = getDate(Integer.parseInt(str4));
//                  //  horizontalBattery.setPower(power);
                    horizontalBattery.setPower(dianliang);
//                  //  int dianliang =  horizontalBattery.getPower();
                   if(dianliang>48){
                       battery_status.setImageResource(R.mipmap.white_battery);
                   }else{
                       battery_status.setImageResource(R.mipmap.red_battery);
                   }
                   battery_num.setText(" "+dianliang+"");
                   voltage_txt.setText(str2+"V");
                   current_txt.setText(str3+"A");
                   duration_txt.setText(time);
                   fee_txt.setText(str5+"元");
//                    if (power == 100) {
//                        power = 0;
//                    }
                    break;
                case 1:
                    status_txt.setText("未充电");
                    linearLayout.setVisibility(View.INVISIBLE);
                    voltage_txt.setText("");
                    current_txt.setText("");
                    duration_txt.setText("");
                    fee_txt.setText("");
                    break;
                default:
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charge);
        title_text = findViewById(R.id.title_text);
        battery_num = findViewById(R.id.battery_num);
        battery_status = findViewById(R.id.battery_status);
        current_txt = findViewById(R.id.current);
        duration_txt = findViewById(R.id.duration);
        fee_txt = findViewById(R.id.fee);
        voltage_txt = findViewById(R.id.voltage);
        linearLayout = findViewById(R.id.battery_p);
        status_txt=findViewById(R.id.status_txt);
        title_text.setText("当前充电信息");

        horizontalBattery = (BatteryView) findViewById(R.id.horizontalBattery);
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                mHandler.sendEmptyMessage(0);
//            }
//        }, 0, 100);


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(true){
//                    try {
//                      //  JSONObject data = ChargeInfo.post("http://36.154.37.114:8082/web/charging");
//                       // power = Integer.parseInt((String) data.get("percent"));
//                     //   mHandler.sendEmptyMessage(0);
//                        power++;
//                        dianya.setText(power+"");
//                        Thread.sleep(500);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Bundle bundle = new Bundle();
                        JSONObject data = ChargeInfo.post("http://36.154.37.114:8082/web/charging");

                        if(data==null){
                            Message msg = new Message();
                            msg.what = 1;
                            mHandler.sendMessage(msg);
                        }
                        else{
                            String percent  = String.valueOf(data.get("percent"));
                            bundle.putString("percent",percent);
                            bundle.putString("voltage", String.valueOf(data.get("voltage")));
                            bundle.putString("current",String.valueOf(data.get("current")));
                            bundle.putString("duration", String.valueOf(data.get("duration")));
                            bundle.putString("fee", String.valueOf(data.get("fee")));
                            Message msg = new Message();
                            msg.what = 0;
                            msg.setData(bundle);
                            mHandler.sendMessage(msg);
                            Log.i("percent",percent);
                        }
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();
    }

    public static String getDate(int date ) {
        if (date<60) {
            return date+"秒";
        }else if (date>60&&date<3600) {
            int m = date/60;
            int s = date%60;
            return m+"分"+s+"秒";
        }else {
            int h = date/3600;
            int m = (date%3600)/60;
            int s = (date%3600)%60;
            return h+"小时"+m+"分"+s+"秒";
        }

    }
}