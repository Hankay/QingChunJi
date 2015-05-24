package com.kevinhan.meituan.Activity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.sax.StartElementListener;
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
import com.kevinhan.meituan.Adapter.FoodGridAdapter;
import com.kevinhan.meituan.Data.Businesses;
import com.kevinhan.meituan.R;
import com.kevinhan.meituan.Utils.AsyncHttpFoodGrid;
import com.yalantis.phoenix.PullToRefreshView;


import java.util.ArrayList;
import java.util.List;


 public class FoodGridActivity extends ActionBarActivity implements AbsListView.OnScrollListener, AbsListView.OnItemClickListener, AdapterView.OnItemLongClickListener ,AsyncHttpFoodGrid.IcallBack{

    private static final String TAG = "FoodGridActivity";
    public static final String SAVED_DATA_KEY = "SAVED_DATA";

    public static final int REFRESH_DELAY = 2000;
    private PullToRefreshView mPullToRefreshView;

    private StaggeredGridView mGridView;
    private boolean mHasRequestedMore;
    private FoodGridAdapter mAdapter;

    private Toolbar mToolbar;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private AnimationDrawable mAnimationDrawable;

    private ArrayList<String> mData;
    private List<Businesses> businessesList;


    private AsyncHttpFoodGrid asyncHttpFoodGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sgv_food);
        setToolBar();
        asyncHttpFoodGrid = new AsyncHttpFoodGrid(this);
        asyncHttpFoodGrid.RequestHttp();
        //phoenx();
        setTitle("SGV");
        mGridView = (StaggeredGridView) findViewById(R.id.grid_view_food);

        LayoutInflater layoutInflater = getLayoutInflater();

        View header = layoutInflater.inflate(R.layout.list_item_header_footer, null);
        View footer = layoutInflater.inflate(R.layout.list_item_header_footer, null);
        TextView txtHeaderTitle = (TextView) header.findViewById(R.id.txt_title);
        TextView txtFooterTitle =  (TextView) footer.findViewById(R.id.txt_title);
        txtHeaderTitle.setText("Welcome Food!");
        txtFooterTitle.setText("THE FOOTER!");

        //mGridView.addHeaderView(header);
        //mGridView.addFooterView(footer);
        //Log.e(TAG, "到这");


        // do we have saved data?
        /*if (savedInstanceState != null) {
            mData = savedInstanceState.getStringArrayList(SAVED_DATA_KEY);
        }

        if (mData == null) {
            mData = SampleData.generateSampleData();
        }

        for (String data : mData) {
            mAdapter.add(data);
        }*/



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

/*    private void onLoadMoreItems() {
        final ArrayList<String> sampleData = SampleData.generateSampleData();
        for (String data : sampleData) {
            mAdapter.add(data);
        }
        // stash all the data in our backing store
        mData.addAll(sampleData);
        // notify the adapter that we can update now
        mAdapter.notifyDataSetChanged();
        mHasRequestedMore = false;
    }*/

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Toast.makeText(this, "Item Clicked: " + position, Toast.LENGTH_SHORT).show();
        switch (position){
            case 0:
                //Log.e(TAG,"0");
                Businesses businesses = businessesList.get(position);
                //Log.e(TAG,"-------"+businesses.getDealses());
                Bundle bundle = new Bundle();
                bundle.putSerializable("businesses",businesses);
                Intent intent0 = new Intent(FoodGridActivity.this,FoodActivity.class);
                intent0.putExtras(bundle);
                startActivity(intent0);
                break;
            case 1:
                Log.e(TAG,"0");
                break;
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
                        //RequestHttp();
                    }
                }, REFRESH_DELAY);
            }
        });
    }

    public void setToolBar(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setLogo(R.mipmap.ic_launcher);
        mToolbar.setTitle(" 美食");
        //mToolbar.setSubtitle("美食");
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
                        Intent intent_login = new Intent(FoodGridActivity.this,LoginActivity.class);
                        startActivity(intent_login);
                        Log.e(TAG, "点击0");
                        break;
                    case 1:
                        mDrawerLayout.closeDrawer(Gravity.START);
                        Intent intent_friends = new Intent(FoodGridActivity.this,FriendShareActivity.class);
                        startActivity(intent_friends);
                        Log.e(TAG, "点击1");
                        break;
                    case 2:
                        mDrawerLayout.closeDrawer(Gravity.START);
                        Intent intent_news = new Intent(FoodGridActivity.this,SchoolNewsActivity.class);
                        startActivity(intent_news);
                        Log.e(TAG,"点击2");
                        break;
                    case 3:
                        mDrawerLayout.closeDrawer(Gravity.START);
                        Intent intent_aboutus = new Intent(FoodGridActivity.this,AboutUsActivity.class);
                        startActivity(intent_aboutus);
                        Log.e(TAG,"点击3");
                        break;
                    case 4:
                        mDrawerLayout.closeDrawer(Gravity.START);
                        Intent intent_setting = new Intent(FoodGridActivity.this,SettingActivity.class);
                        startActivity(intent_setting);
                        Log.e(TAG,"点击3");
                        break;
                    case 5:
                        mDrawerLayout.closeDrawer(Gravity.START);
                        Intent intent_updates = new Intent(FoodGridActivity.this,UpdatesActivity.class);
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
                        Toast.makeText(FoodGridActivity.this, "已关注", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_share:
                        Toast.makeText(FoodGridActivity.this, "分享", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
    }

     @Override
     public void callBackResult(List<Businesses> businessesList) {
         //Log.e(TAG,"businessesList->"+businessesList);
         mAdapter = new FoodGridAdapter(this,businessesList);
         this.businessesList = businessesList;
         Log.e(TAG,"-------"+businessesList.get(0).toString());
         mGridView.setAdapter(mAdapter);
     }
 }

