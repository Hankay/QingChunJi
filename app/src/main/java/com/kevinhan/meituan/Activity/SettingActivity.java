package com.kevinhan.meituan.Activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.kevinhan.meituan.R;


/**
 * Created by Kevin han on 2015/5/23.
 */
public class SettingActivity extends Activity implements View.OnClickListener{
    private TextView tv_setting_custom;
    private TextView tv_setting_message;
    private TextView tv_setting_feedback;
    private TextView tv_setting_network;
    private TextView tv_setting_cache;
    private TextView tv_setting_share;
    private TextView tv_setting_textsize;
    private TextView tv_setting_sweep;
    private TextView tv_setting_pay;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        init();
        setListener();
    }

    public void init(){
        tv_setting_custom = (TextView)findViewById(R.id.tv_setting_custom);
        tv_setting_message = (TextView)findViewById(R.id.tv_setting_message);
        tv_setting_feedback = (TextView)findViewById(R.id.tv_setting_feedback);
        tv_setting_network = (TextView)findViewById(R.id.tv_setting_network);
        tv_setting_cache = (TextView)findViewById(R.id.tv_setting_cache);
        tv_setting_share = (TextView)findViewById(R.id.tv_setting_share);
        tv_setting_textsize = (TextView)findViewById(R.id.tv_setting_textsize);
        tv_setting_sweep = (TextView)findViewById(R.id.tv_setting_sweep);
        tv_setting_pay = (TextView)findViewById(R.id.tv_setting_pay);
    }

    public void setListener(){
        tv_setting_custom.setOnClickListener(this);
        tv_setting_message.setOnClickListener(this);
        tv_setting_feedback.setOnClickListener(this);
        tv_setting_network.setOnClickListener(this);
        tv_setting_cache.setOnClickListener(this);
        tv_setting_share.setOnClickListener(this);
        tv_setting_textsize.setOnClickListener(this);
        tv_setting_sweep.setOnClickListener(this);
        tv_setting_pay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_setting_message:
                Toast.makeText(this,"你有新的消息",Toast.LENGTH_SHORT).show();
                break;

            case R.id.tv_setting_feedback:
                Intent intent_message = new Intent(SettingActivity.this,AboutUsActivity.class);
                startActivity(intent_message);
                break;

            case R.id.tv_setting_network:
                //Toast.makeText(this, "网络状态", Toast.LENGTH_SHORT).show();
                Boolean isConnected = isNetworkConnected();
                if (isConnected == true){
                    Toast.makeText(this, "网络已连接", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "网络未连接", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.tv_setting_cache:
                Toast.makeText(this, "清空缓存", Toast.LENGTH_SHORT).show();
                break;

            case R.id.tv_setting_share:
                Toast.makeText(this, "分享设置", Toast.LENGTH_SHORT).show();
                break;

            case R.id.tv_setting_textsize:
                Toast.makeText(this,"字体大小",Toast.LENGTH_SHORT).show();


            case R.id.tv_setting_sweep:
                Toast.makeText(this, "扫一扫", Toast.LENGTH_SHORT).show();
                break;

            case R.id.tv_setting_pay:
                Toast.makeText(this,"支付设置",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * 检测网络是否可用
     *
     * @return
     */
    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return ni != null && ni.isConnectedOrConnecting();
    }
}
