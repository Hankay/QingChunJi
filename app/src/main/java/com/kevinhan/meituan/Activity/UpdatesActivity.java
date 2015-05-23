package com.kevinhan.meituan.Activity;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kevinhan.meituan.R;

/**
 * Created by Kevin Han on 2015/5/23.
 */
public class UpdatesActivity extends Activity {

    private ImageView iv_updates;
    private TextView tv_updates;
    private Button bt_updates;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updates);
        init();
        set();
    }


    public void init(){
        iv_updates = (ImageView)findViewById(R.id.iv_updates);
        tv_updates = (TextView)findViewById(R.id.tv_updates);
        bt_updates = (Button)findViewById(R.id.bt_updates);
    }

    public void set(){
        Drawable updates = this.getResources().getDrawable(R.drawable.thumb);
        iv_updates.setImageDrawable(updates);//设置图片
        bt_updates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UpdatesActivity.this, "最新版本", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
