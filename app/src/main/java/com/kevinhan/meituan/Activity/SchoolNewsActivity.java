package com.kevinhan.meituan.Activity;

/**
 * Created by Kevin han on 2015/5/21.
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

public class SchoolNewsActivity extends Activity implements AdapterView.OnItemClickListener {

    private String TAG = "SchoolNewsActivity";
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
        Log.e(TAG, "shareListAdapter----" + shareListAdapter);
        lv_friend_share.setAdapter(shareListAdapter);
        lv_friend_share.setOnItemClickListener(this);
    }

    public List<ShareDates> setShareDates(){
        List<ShareDates> shareDatesList = new ArrayList<ShareDates>();
        ShareDates shareDates = new ShareDates();
        for (int i=0; i<20; i++){
            shareDates.setName_url("http://i2.dpfile.com/pc/6216d48d7b410f80fe8a14d81d54a8f0(278x200)/thumb.jpg");
            shareDates.setName("青春集");
            shareDates.setInfo("5月20日，我校大学生电商创业平台建设取得新进展，首个大学生电商创业培训与实习基地在茂名市电子商务协会成立。我校党委副书记王恒胤和茂名市电子商务协会会长曾宪繁共同为基地揭牌。\n" +
                    "\n" +
                    "揭牌仪式后，校企双方就基地建设、电商人才培养、创业实践平台建设进行了探讨。王恒胤认为，双方拥有良好的合作基础，校企深入合作可以为我校学生提供更多创业实践机会，促进大学生创新创业工作，为我校培养更多“创客”创造条件。" +
                    "希望双方以务实的精神，紧抓当前经济发展新机遇，加强合作，以科研合作、人才培养、就业创业为抓手形成优势互补，取得互利共赢。");
            shareDatesList.add(shareDates);
        }
        return shareDatesList;

    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(this, "Item Clicked: " + position, Toast.LENGTH_SHORT).show();
    }
}

