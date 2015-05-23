package com.kevinhan.meituan.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.kevinhan.meituan.Data.ShareDates;
import com.kevinhan.meituan.R;

import java.util.List;

/**
 * Created by Kevin Han on 2015/5/23.
 */
public class ShareListAdapter extends BaseAdapter{

    private String TAG="ShareListAdapter";
    private Context context;
    private LayoutInflater mLayoutInflater;
    private List<ShareDates> shareDatesList;
    public ShareListAdapter(Context context,List<ShareDates> shareDatesList){
        this.context = context;
        mLayoutInflater = LayoutInflater.from(context);
        this.shareDatesList = shareDatesList;
    }

    //在外面先定义，ViewHolder静态类
    static class ViewHolder
    {
        public ImageView iv_share_name;
        public TextView tv_share_name;
        private Button bt_share;
        public TextView tv_share;
    }

    @Override
    public int getCount() {
        return shareDatesList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null)
        {
            holder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.activity_share_list, null);
            holder.iv_share_name = (ImageView)convertView.findViewById(R.id.iv_share_name);
            holder.tv_share_name = (TextView)convertView.findViewById(R.id.tv_share_name);
            holder.bt_share = (Button)convertView.findViewById(R.id.bt_share);
            holder.tv_share = (TextView)convertView.findViewById(R.id.tv_share);
            convertView.setTag(holder);
        }else
        {
            holder = (ViewHolder)convertView.getTag();
        }

        holder.iv_share_name.setImageResource(R.drawable.thumb);
        holder.tv_share_name.setText(shareDatesList.get(position).getName());
        holder.bt_share.setText("分享");
        holder.tv_share.setText(shareDatesList.get(position).getInfo());
        return convertView;
    }

}
