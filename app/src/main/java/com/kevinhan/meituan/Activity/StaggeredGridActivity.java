package com.kevinhan.meituan.Activity;

/**
 * Created by Kevin Han on 2015/4/6.
 */
import java.util.ArrayList;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.etsy.android.grid.StaggeredGridView;
import com.kevinhan.meituan.Adapter.SampleAdapter;
import com.kevinhan.meituan.Data.Business;
import com.kevinhan.meituan.Data.SampleData;
import com.kevinhan.meituan.R;
import com.yalantis.phoenix.PullToRefreshView;

import com.loopj.android.http.*;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;

import com.alibaba.fastjson.JSON;


public class StaggeredGridActivity extends ActionBarActivity implements AbsListView.OnScrollListener, AbsListView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private static final String TAG = "StaggeredGridActivity";
    public static final String SAVED_DATA_KEY = "SAVED_DATA";

    public static final int REFRESH_DELAY = 2000;
    private PullToRefreshView mPullToRefreshView;

    private StaggeredGridView mGridView;
    private boolean mHasRequestedMore;
    private SampleAdapter mAdapter;

    private Toolbar mToolbar;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView lvLeftMenu;
    private AnimationDrawable mAnimationDrawable;

    private ArrayList<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sgv);
        setToolBar();
        //phoenx();
        setTitle("SGV");
        mGridView = (StaggeredGridView) findViewById(R.id.grid_view);

        LayoutInflater layoutInflater = getLayoutInflater();

        View header = layoutInflater.inflate(R.layout.list_item_header_footer, null);
        View footer = layoutInflater.inflate(R.layout.list_item_header_footer, null);
        TextView txtHeaderTitle = (TextView) header.findViewById(R.id.txt_title);
        TextView txtFooterTitle =  (TextView) footer.findViewById(R.id.txt_title);
        txtHeaderTitle.setText("Welcome!");
        txtFooterTitle.setText("THE FOOTER!");

        //mGridView.addHeaderView(header);
        //mGridView.addFooterView(footer);
        mAdapter = new SampleAdapter(this, R.id.txt_line1);

        // do we have saved data?
        if (savedInstanceState != null) {
            mData = savedInstanceState.getStringArrayList(SAVED_DATA_KEY);
        }

        if (mData == null) {
            mData = SampleData.generateSampleData();
        }

        for (String data : mData) {
            mAdapter.add(data);
        }

        mGridView.setAdapter(mAdapter);
        mGridView.setOnScrollListener(this);
        mGridView.setOnItemClickListener(this);
        mGridView.setOnItemLongClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sgv_dynamic, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_star:
                mGridView.setColumnCount(1);
                break;
            case R.id.menu_share:
                mGridView.setColumnCount(2);
                break;
        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList(SAVED_DATA_KEY, mData);
    }

    @Override
    public void onScrollStateChanged(final AbsListView view, final int scrollState) {
        Log.d(TAG, "onScrollStateChanged:" + scrollState);
    }

    @Override
    public void onScroll(final AbsListView view, final int firstVisibleItem, final int visibleItemCount, final int totalItemCount) {
        Log.d(TAG, "onScroll firstVisibleItem:" + firstVisibleItem +
                " visibleItemCount:" + visibleItemCount +
                " totalItemCount:" + totalItemCount);
        // our handling
        if (!mHasRequestedMore) {
            int lastInScreen = firstVisibleItem + visibleItemCount;
            if (lastInScreen >= totalItemCount) {
                Log.d(TAG, "onScroll lastInScreen - so load more");
                mHasRequestedMore = true;
                //onLoadMoreItems();
            }
        }
    }

    private void onLoadMoreItems() {
        final ArrayList<String> sampleData = SampleData.generateSampleData();
        for (String data : sampleData) {
            mAdapter.add(data);
        }
        // stash all the data in our backing store
        mData.addAll(sampleData);
        // notify the adapter that we can update now
        mAdapter.notifyDataSetChanged();
        mHasRequestedMore = false;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(this, "Item Clicked: " + position, Toast.LENGTH_SHORT).show();
        switch (position){
            case 0:
                Log.e(TAG,"美食");
                Intent intent_food = new Intent(StaggeredGridActivity.this,FoodGridActivity.class);
                startActivity(intent_food);
                break;
            case 1:
                Log.e(TAG,"电影");
                Intent intent_movie = new Intent(StaggeredGridActivity.this,MovieGridActivity.class);
                startActivity(intent_movie);
                break;
            case 2:
                Log.e(TAG,"娱乐");
                Intent intent_amusement = new Intent(StaggeredGridActivity.this,AmusementGridActivity.class);
                startActivity(intent_amusement);
                break;
            case 3:
                Log.e(TAG,"酒店");
                Intent intent_hotel = new Intent(StaggeredGridActivity.this,HotelGridActivity.class);
                startActivity(intent_hotel);

        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id)
    {
        Toast.makeText(this, "Item Long Clicked: " + position, Toast.LENGTH_SHORT).show();
        return true;
    }

    /**
     * 下拉刷新
     */
    public void phoenx(){
        mPullToRefreshView = (PullToRefreshView) findViewById(R.id.pull_to_refresh);
        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPullToRefreshView.setRefreshing(false);
                        //RequestDataAPI();//网络请求
                        RequestHttp();
                    }
                }, REFRESH_DELAY);
            }
        });
    }

    public void setToolBar(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setLogo(R.mipmap.ic_launcher);
        mToolbar.setTitle("首页");
        //mToolbar.setSubtitleTextColor();
        /*mToolbar.setSubtitle("Home");*/
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final DrawerLayout mDrawerLayout = (DrawerLayout)findViewById(R.id.dl_left);
        ListView mDrawerList = (ListView)findViewById(R.id.lv_left_menu);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //mAnimationDrawable.stop();
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                //mAnimationDrawable.start();
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        //左侧菜单
        String[] values = new String[]{
                "& 我的青春集", "& 好友动态", "& 校园新闻", "& 关于我们","& 设置","& 版本更新"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        mDrawerLayout.closeDrawer(Gravity.START);
                        Intent intent_login = new Intent(StaggeredGridActivity.this,LoginActivity.class);
                        startActivity(intent_login);
                        Log.e(TAG, "点击0");
                        break;
                    case 1:
                        mDrawerLayout.closeDrawer(Gravity.START);
                        Intent intent_friends = new Intent(StaggeredGridActivity.this,FriendShareActivity.class);
                        startActivity(intent_friends);
                        Log.e(TAG, "点击1");
                        break;
                    case 2:
                        mDrawerLayout.closeDrawer(Gravity.START);
                        Intent intent_news = new Intent(StaggeredGridActivity.this,SchoolNewsActivity.class);
                        startActivity(intent_news);
                        Log.e(TAG,"点击2");
                        break;
                    case 3:
                        mDrawerLayout.closeDrawer(Gravity.START);
                        Intent intent_aboutus = new Intent(StaggeredGridActivity.this,AboutUsActivity.class);
                        startActivity(intent_aboutus);
                        Log.e(TAG,"点击3");
                        break;
                    case 4:
                        mDrawerLayout.closeDrawer(Gravity.START);
                        Intent intent_setting = new Intent(StaggeredGridActivity.this,SettingActivity.class);
                        startActivity(intent_setting);
                        Log.e(TAG,"点击3");
                        break;
                    case 5:
                        mDrawerLayout.closeDrawer(Gravity.START);
                        Intent intent_updates = new Intent(StaggeredGridActivity.this,UpdatesActivity.class);
                        startActivity(intent_updates);
                        Log.e(TAG,"点击3");
                        break;
                }

            }
        });

        //右上角菜单
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_star:
                        Toast.makeText(StaggeredGridActivity.this, "已关注", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_share:
                        Toast.makeText(StaggeredGridActivity.this, "分享", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
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
                Log.e(TAG,response.toString());
                Business business = JSON.parseObject(response.toString(), Business.class);
                Log.e(TAG, "getTotal_count" + business.getTotal_count());
            }
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                // Handle resulting parsed JSON response here
                Log.e(TAG,response.toString());
            }
        });
    }

}
