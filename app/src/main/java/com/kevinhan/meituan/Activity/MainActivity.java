package com.kevinhan.meituan.Activity;

/*import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.os.Bundle;

import com.kevinhan.meituan.Fragment.LayoutFragment;
import com.kevinhan.meituan.R;
import com.yalantis.phoenix.PullToRefreshView;*/


/**
 * Created by Kevin on 2015/4/28.
 */



/*
public class MainActivity extends ActionBarActivity {

    public static final int REFRESH_DELAY = 2000;
    private PullToRefreshView mPullToRefreshView;
    private final String ARG_SELECTED_LAYOUT_ID = "selectedLayoutId";
    private final int DEFAULT_LAYOUT = R.layout.layout_list;
    private int mSelectedLayoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(false);

        mSelectedLayoutId = DEFAULT_LAYOUT;
        if (savedInstanceState != null) {
            mSelectedLayoutId = savedInstanceState.getInt(ARG_SELECTED_LAYOUT_ID);
        }

        addLayoutTab(
                actionBar, R.layout.layout_list, R.mipmap.ic_list, "list");
        addLayoutTab(
                actionBar, R.layout.layout_grid, R.mipmap.ic_grid, "grid");
        addLayoutTab(
                actionBar, R.layout.layout_staggered_grid, R.mipmap.ic_staggered, "staggered");
        addLayoutTab(
                actionBar, R.layout.layout_spannable_grid, R.mipmap.ic_spannable, "spannable");


        phoenx();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_SELECTED_LAYOUT_ID, mSelectedLayoutId);
    }

    private void addLayoutTab(ActionBar actionBar, int layoutId, int iconId, String tag) {
        ActionBar.Tab tab = actionBar.newTab()
                .setText("")
                .setIcon(iconId)
                .setTabListener(new TabListener(layoutId, tag));
        actionBar.addTab(tab, layoutId == mSelectedLayoutId);
    }

    public class TabListener implements ActionBar.TabListener {
        private LayoutFragment mFragment;
        private final int mLayoutId;
        private final String mTag;

        public TabListener(int layoutId, String tag) {
            mLayoutId = layoutId;
            mTag = tag;
        }

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            mFragment = (LayoutFragment) getSupportFragmentManager().findFragmentByTag(mTag);
            if (mFragment == null) {
                mFragment = (LayoutFragment) LayoutFragment.newInstance(mLayoutId);
                ft.add(R.id.content, mFragment, mTag);
            } else {
                ft.attach(mFragment);
            }

            mSelectedLayoutId = mFragment.getLayoutId();
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            if (mFragment != null) {
                ft.detach(mFragment);
            }
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        }

    }

    *//*

    public void phoenx(){
        mPullToRefreshView = (PullToRefreshView) findViewById(R.id.pull_to_refresh);
        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPullToRefreshView.setRefreshing(false);
                    }
                }, REFRESH_DELAY);
            }
        });
    }
}
*/
