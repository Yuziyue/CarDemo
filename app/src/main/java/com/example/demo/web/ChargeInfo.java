package com.example.demo.web;

import com.alibaba.fastjson.JSONObject;

public class ChargeInfo {
    public static JSONObject post(String url) {
        if(url == null)
            url = "http://localhost:8082/web/plug";

        String respStr = new WebRequest().post().to(url).executeSync();
        JSONObject resp = JSONObject.parseObject(respStr);

        return resp.getJSONObject("data");
        //return respStr;
    }
}
