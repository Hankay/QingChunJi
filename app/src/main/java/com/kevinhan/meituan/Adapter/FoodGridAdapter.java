package com.kevinhan.meituan.Adapter;

/**
 * Created by Kevin han on 2015/5/6.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.etsy.android.grid.util.DynamicHeightImageView;
import com.etsy.android.grid.util.DynamicHeightTextView;
import com.kevinhan.meituan.Data.Business;
import com.kevinhan.meituan.Data.Businesses;
import com.kevinhan.meituan.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/***
 * ADAPTER
 */

public class FoodGridAdapter extends BaseAdapter {

    private static final String TAG = "SampleAdapter";
    private Business business ;
    private Businesses businesses;

    static class ViewHolder {
        DynamicHeightImageView lvLineone;
        DynamicHeightTextView txtLineOne;
        Button btnGo;
    }

    private final LayoutInflater mLayoutInflater;
    private final Random mRandom;
    private final ArrayList<Integer> mBackgroundColors;
    private final Context mContext;
    private List<Businesses> mBusinessesList;
    private static final SparseArray<Double> sPositionHeightRatios = new SparseArray<Double>();

    public FoodGridAdapter(Context context, List<Businesses> businessesList) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mBusinessesList = businessesList;
        mRandom = new Random();
        mBackgroundColors = new ArrayList<Integer>();
        mBackgroundColors.add(R.color.Black);
        mBackgroundColors.add(R.color.Black);
        mBackgroundColors.add(R.color.Black);
        mBackgroundColors.add(R.color.Black);
        mBackgroundColors.add(R.color.Black);
    }

    @Override
    public int getCount() {
              return mBusinessesList.size();
    }

    @Override
    public Object getItem(int position) {
        return mBusinessesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        ViewHolder vh;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.list_item_sample, parent, false);
            vh = new ViewHolder();
            vh.lvLineone = (DynamicHeightImageView)convertView.findViewById(R.id.iv_line1);
            vh.txtLineOne = (DynamicHeightTextView) convertView.findViewById(R.id.txt_line1);
            vh.btnGo = (Button) convertView.findViewById(R.id.btn_go);

            convertView.setTag(vh);
        }
        else {
            vh = (ViewHolder) convertView.getTag();
        }

        double positionHeight = getPositionRatio(position);
        int backgroundIndex = position >= mBackgroundColors.size() ?
                position % mBackgroundColors.size() : position;

        convertView.setBackgroundResource(mBackgroundColors.get(backgroundIndex));
        //convertView.setBackgroundResource(R.mipmap.thumb);
        Log.d(TAG, "getView position:" + position + " h:" + positionHeight);
        //单行数据
        businesses = mBusinessesList.get(position);

        //图片url
        String imagerUrl = businesses.getPhoto_url();
        DisplayImageOptions options =new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.thumb)
                .showImageOnFail(R.drawable.thumb)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        ImageLoader.getInstance().displayImage(imagerUrl,vh.lvLineone,options);

        vh.lvLineone.setHeightRatio(positionHeight);
        //vh.lvLineone.setBackgroundResource(R.drawable.thumb);
        vh.txtLineOne.setHeightRatio(positionHeight);
        vh.txtLineOne.setText(businesses.getName());
        vh.btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Toast.makeText(mContext, "Button Clicked Position " +
                        position, Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    private double getPositionRatio(final int position) {
        double ratio = sPositionHeightRatios.get(position, 0.0);
        // if not yet done generate and stash the columns height
        // in our real world scenario this will be determined by
        // some match based on the known height and width of the image
        // and maybe a helpful way to get the column height!
        if (ratio == 0) {
            ratio = getRandomHeightRatio();
            sPositionHeightRatios.append(position, ratio);
            Log.d(TAG, "getPositionRatio:" + position + " ratio:" + ratio);
        }
        return ratio;
    }

    private double getRandomHeightRatio() {
        return (mRandom.nextDouble() / 2.0) + 1.0; // height will be 1.0 - 1.5 the width
    }
}
