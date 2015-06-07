package com.kevinhan.meituan.Activity;

/**
 * Created by Kevin Han on 2015/5/6.
 */
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import com.kevinhan.meituan.Data.Businesses;
import com.kevinhan.meituan.R;
import com.kevinhan.meituan.Utils.AsyncHttpFood;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class FoodActivity extends Activity {

    private String TAG = "FoodActivity";
    private AsyncHttpFood asyncHttpFood;
    private String postion;
    private Businesses mBusinesses;
    private ImageView iv_food;
    private TextView tv_name_one;
    private TextView tv_name;
    private TextView tv_address_one;
    private TextView tv_address;
    private TextView tv_telephone_one;
    private TextView tv_telephone;
    private Button bt_telephone;
    private TextView tv_deals;
    private TextView tv_deals1;
    private TextView tv_deals2;
    private Businesses businesses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list_view);
        setContentView(R.layout.activity_food);
        init();
        Intent intent = getIntent();
        Businesses businesses = (Businesses)intent.getSerializableExtra("businesses");
        Log.e(TAG, "position->"+businesses.toString());
        mBusinesses = businesses;
        set();
    }

    public void set(){

        //图片url
        String imagerUrl = mBusinesses.getPhoto_url();
        DisplayImageOptions options =new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.thumb)
                .showImageOnFail(R.drawable.thumb)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        ImageLoader.getInstance().displayImage(imagerUrl,iv_food,options);

        tv_name.setText(mBusinesses.getName());
        tv_address.setText(mBusinesses.getAddress());
        tv_telephone.setText(mBusinesses.getTelephone());
        Log.e(TAG, "-------" + mBusinesses.getDealses().get(0).getDescription());
        tv_deals1.setText(mBusinesses.getDealses().get(0).getDescription());
        tv_deals2.setText(mBusinesses.getDealses().get(1).getDescription());

        bt_telephone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
                        + mBusinesses.getTelephone()));
                startActivity(intent);
            }
        });
    }

    public void init(){
        iv_food = (ImageView)findViewById(R.id.iv_food);
        tv_name_one = (TextView)findViewById(R.id.tv_name_one);
        tv_name = (TextView)findViewById(R.id.tv_name);
        tv_address_one = (TextView)findViewById(R.id.tv_address_one);
        tv_address = (TextView)findViewById(R.id.tv_address);
        tv_telephone_one = (TextView)findViewById(R.id.tv_telephone_one);
        tv_telephone = (TextView)findViewById(R.id.tv_telephone);
        bt_telephone = (Button)findViewById(R.id.bt_telephone);
        tv_deals = (TextView)findViewById(R.id.tv_deals);
        tv_deals1 = (TextView)findViewById(R.id.tv_deals1);
        tv_deals2 = (TextView)findViewById(R.id.tv_deals2);
    }

}
