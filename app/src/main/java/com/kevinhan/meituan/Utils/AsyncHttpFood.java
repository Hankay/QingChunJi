package com.kevinhan.meituan.Utils;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.kevinhan.meituan.Data.Business;
import com.kevinhan.meituan.Data.Businesses;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Kevin han on 2015/5/22.
 */
public class AsyncHttpFood {
    String TAG = "AsyncHttpFoodGrid";
    private List<Businesses> businessesList;
    private Business business;
    private IcallBack mIcallBack;


    public AsyncHttpFood(IcallBack icallBack){
        mIcallBack = icallBack;
    }

    /**
     * 请求美食商户信息
     */
    public void RequestHttp(){
        String url = "http://api.dianping.com/v1/business/find_businesses?appkey=6522233822&sign=82522B29434E63764CA61B4E23ECA32C06CBA2EB&category=%E7%BE%8E%E9%A3%9F&city=%E4%B8%8A%E6%B5%B7&latitude=31.18268013000488&longitude=121.42769622802734&sort=1&limit=20&offset_type=1&out_offset_type=1&platform=2";
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(url,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // Handle resulting parsed JSON response here
                Log.e(TAG, response.toString());
                business = JSON.parseObject(response.toString(), Business.class);
                businessesList = business.getBusinesses();//mAdapter.setDate(businessesList);
                //Log.e(TAG, "businessesList->" + businessesList);
                mIcallBack.callBackResult(businessesList);
            }
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                // Handle resulting parsed JSON response here
                Log.e(TAG,response.toString());
            }
        });
    }

    public interface IcallBack{
        void callBackResult(List<Businesses> businessesList);
    }
}
