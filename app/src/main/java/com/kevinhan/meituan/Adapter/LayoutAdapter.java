package com.kevinhan.meituan.Adapter;

/**
 * Created by Kevin han on 2015/5/5.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kevinhan.meituan.R;

import org.lucasr.twowayview.TwoWayLayoutManager;
import org.lucasr.twowayview.widget.TwoWayView;
import org.lucasr.twowayview.widget.SpannableGridLayoutManager;
import org.lucasr.twowayview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class LayoutAdapter extends RecyclerView.Adapter<LayoutAdapter.SimpleViewHolder> {
    private static final int COUNT = 100;

    private final Context mContext;
    private final TwoWayView mRecyclerView;
    private final List<Integer> mItems;
    private final int mLayoutId;
    private int mCurrentItemId = 0;

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {
        public final TextView title;

        public SimpleViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
        }
    }

    public LayoutAdapter(Context context, TwoWayView recyclerView, int layoutId) {
        mContext = context;
        mItems = new ArrayList<Integer>(COUNT);
        for (int i = 0; i < COUNT; i++) {
            addItem(i);
        }

        mRecyclerView = recyclerView;
        mLayoutId = layoutId;
    }

    public void addItem(int position) {
        final int id = mCurrentItemId++;
        mItems.add(position, id);
        notifyItemInserted(position);
    }

    public void removeItem(int position) {
        mItems.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        holder.title.setText(mItems.get(position).toString());

        boolean isVertical = (mRecyclerView.getOrientation() == TwoWayLayoutManager.Orientation.VERTICAL);
        final View itemView = holder.itemView;

        final int itemId = mItems.get(position);

        if (mLayoutId == R.layout.layout_staggered_grid) {
            final int dimenId;
            if (itemId % 3 == 0) {
                dimenId = R.dimen.staggered_child_medium;
            } else if (itemId % 5 == 0) {
                dimenId = R.dimen.staggered_child_large;
            } else if (itemId % 7 == 0) {
                dimenId = R.dimen.staggered_child_xlarge;
            } else {
                dimenId = R.dimen.staggered_child_small;
            }

            final int span;
            if (itemId == 2) {
                span = 2;
            } else {
                span = 1;
            }

            final int size = mContext.getResources().getDimensionPixelSize(dimenId);

            final StaggeredGridLayoutManager.LayoutParams lp =
                    (StaggeredGridLayoutManager.LayoutParams) itemView.getLayoutParams();

            if (!isVertical) {
                lp.span = span;
                lp.width = size;
                itemView.setLayoutParams(lp);
            } else {
                lp.span = span;
                lp.height = size;
                itemView.setLayoutParams(lp);
            }
        } else if (mLayoutId == R.layout.layout_spannable_grid) {
            final SpannableGridLayoutManager.LayoutParams lp =
                    (SpannableGridLayoutManager.LayoutParams) itemView.getLayoutParams();

            final int span1 = (itemId == 0 || itemId == 3 ? 2 : 1);
            final int span2 = (itemId == 0 ? 2 : (itemId == 3 ? 3 : 1));

            final int colSpan = (isVertical ? span2 : span1);
            final int rowSpan = (isVertical ? span1 : span2);

            if (lp.rowSpan != rowSpan || lp.colSpan != colSpan) {
                lp.rowSpan = rowSpan;
                lp.colSpan = colSpan;
                itemView.setLayoutParams(lp);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}