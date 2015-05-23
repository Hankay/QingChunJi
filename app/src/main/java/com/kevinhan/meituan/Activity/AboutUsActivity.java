package com.kevinhan.meituan.Activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.kevinhan.meituan.R;

/**
 * Created by Kevin Han on 2015/5/21.
 */
public class AboutUsActivity extends Activity {
    private ImageView iv_aboutus;
    private Button bt_aboutus_service;
    private String TAG ="AboutUsActivity";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        init();
        set();
    }


    public void init(){
        iv_aboutus =  (ImageView)findViewById(R.id.iv_about_us);
        bt_aboutus_service = (Button)findViewById(R.id.bt_aboutus_service);
    }

    public void set(){
        Drawable aboutus = this.getResources().getDrawable(R.drawable.thumb);
        iv_aboutus.setImageDrawable(aboutus);//设置图片
        bt_aboutus_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG,"onClick");
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
                        + "14718070202"));
                startActivity(intent);
            }
        });
    }
}
