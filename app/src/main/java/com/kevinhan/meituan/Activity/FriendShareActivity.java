package com.kevinhan.meituan.Activity;

/**
 * Created by Kevin Han on 2015/5/21.
 */

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.kevinhan.meituan.Adapter.FoodGridAdapter;
import com.kevinhan.meituan.Adapter.SampleAdapter;
import com.kevinhan.meituan.Adapter.ShareListAdapter;
import com.kevinhan.meituan.Data.Businesses;
import com.kevinhan.meituan.Data.SampleData;
import com.kevinhan.meituan.Data.ShareDates;
import com.kevinhan.meituan.R;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Kevin Han on 2015/5/6.
 */


public class FriendShareActivity extends Activity implements AdapterView.OnItemClickListener {

    private String TAG ="FriendShareActivity";
    private TextView tv_friend_share;
    private ListView lv_friend_share;
    private List<ShareDates> mShareDatesList;
    private ShareListAdapter shareListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_share);
        init();
        mShareDatesList = setShareDates();
        set();
    }

    public void init(){
        tv_friend_share = (TextView)findViewById(R.id.tv_friend_share);
        lv_friend_share = (ListView)findViewById(R.id.lv_friend_share);
    }

    public void set(){
        shareListAdapter = new ShareListAdapter(this,mShareDatesList);
        Log.e(TAG,"shareListAdapter----"+shareListAdapter);
        lv_friend_share.setAdapter(shareListAdapter);
        lv_friend_share.setOnItemClickListener(this);
    }

    public List<ShareDates> setShareDates(){
        List<ShareDates> shareDatesList = new ArrayList<ShareDates>();
        ShareDates shareDates = new ShareDates();
        for (int i=0; i<20; i++){
            shareDates.setName_url("http://i2.dpfile.com/pc/6216d48d7b410f80fe8a14d81d54a8f0(278x200)/thumb.jpg");
            shareDates.setName("青春集");
            shareDates.setInfo("每一个平凡的人都以一个不为人知的不平凡的世界，每个平静背后都有激情澎湃，无声有时胜似有声。\n" +
                    "\n" +
                    "　　读过不少的小说，也有一些情节特别引人入胜的，读之不愿放下的，却没有一本像路遥的绝笔之作——《平凡的世界》那么深入我心的。看其中一个个平凡世界中平凡的人物，就如他们正生活在我的身边。");
            shareDatesList.add(shareDates);
        }
        return shareDatesList;

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(this, "Item Clicked: " + position, Toast.LENGTH_SHORT).show();
    }
}

