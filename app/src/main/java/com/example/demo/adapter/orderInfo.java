package com.example.demo.adapter;

public class orderInfo {
    protected String order_no = "";
    protected String order_status = "";
    protected String order_time = "";
    protected String charge_level = "";
    protected String order_amount = "";
    protected static final String NO_PREFIX = "";
    protected static final String STATUS_PREFIX = "";
    protected static final String TIME_PREFIX = "";
    protected static final String LEVEL_PREFIX = "";
    protected static final String AMOUNT_PREFIX = "";

    public orderInfo(String order_no,String order_status,String order_time, String charge_level, String order_amount){
        this.order_no = order_no;
        this.order_status = order_status;
        this.order_time = order_time;
        this.charge_level = charge_level;
        this.order_amount = order_amount;
    }
}
