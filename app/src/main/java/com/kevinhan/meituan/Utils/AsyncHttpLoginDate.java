package com.kevinhan.meituan.Utils;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.kevinhan.meituan.Data.Login;
import com.kevinhan.meituan.Data.LoginDates;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Kevin Han on 2015/5/27.
 */
public class AsyncHttpLoginDate {
    String TAG = "AsyncHttpLoginGrid";
    private List<Login> loginList;
    private LoginDates loginDates;
    private IcallBack mIcallBack;


    public  AsyncHttpLoginDate(IcallBack icallBack){
        mIcallBack = icallBack;
    }

    /**
     * 请求美食商户信息
     */
    public void RequestHttp(){
        String url = "http://10.95.23.83:8080/QingChunJi-Relese/Login";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // Handle resulting parsed JSON response here
                Log.e(TAG, response.toString());
                loginDates = JSON.parseObject(response.toString(), LoginDates.class);
                Log.e(TAG,"status->"+loginDates.getStatus());
                loginList = loginDates.getLogin();//mAdapter.setDate(businessesList);
                //Log.e(TAG, "loginDateList->" + loginList);
                mIcallBack.callBackResult(loginList);
            }
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                // Handle resulting parsed JSON response here
                Log.e(TAG,response.toString());
            }
        });
    }

    public interface IcallBack{
        void callBackResult(List<Login> loginDateList);
    }
}
