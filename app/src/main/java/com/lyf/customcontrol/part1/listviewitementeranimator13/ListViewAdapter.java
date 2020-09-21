package com.lyf.customcontrol.part1.listviewitementeranimator13;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import com.lyf.customcontrol.R;

import java.util.List;

class ListViewAdapter extends BaseAdapter implements AbsListView.OnScrollListener {

    private Context mContext;
    private ListView mListView;
    private List<Drawable> mDrawables;
    private int mLength;
    private LayoutInflater mLayoutInflater;
    private Animation animation;

    private boolean isScrollUp;
    private int mLastFirstVisibleItem;
    private int mFirstTop;

    public ListViewAdapter(Context context, ListView listView, List<Drawable> drawables, int length) {
        mContext = context;
        mListView = listView;
        mDrawables = drawables;
        mLength = length;
        mLayoutInflater = LayoutInflater.from(mContext);
        animation = AnimationUtils.loadAnimation(mContext, R.anim.list_view_bottom_in);

        mListView.setOnScrollListener(this);
    }

    @Override
    public int getCount() {
        return mLength;
    }

    @Override
    public Object getItem(int position) {
        return mDrawables.get(position % mDrawables.size());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder myViewHolder;
        if (convertView == null) {
            myViewHolder = new MyViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.item_listview_image, parent, false);
            myViewHolder.imageView = convertView.findViewById(R.id.imageView);
            myViewHolder.index = convertView.findViewById(R.id.index);
        } else {
            myViewHolder = (MyViewHolder) convertView.getTag();
        }

        //清除当前显示区域中所有item的动画
        for (int i = 0; i < mListView.getChildCount(); i++) {
            View view = mListView.getChildAt(i);
            view.clearAnimation();
        }

        if (isScrollUp)
            convertView.startAnimation(animation);

        convertView.setTag(myViewHolder);


        myViewHolder.imageView.setImageDrawable(mDrawables.get(position % mDrawables.size()));
        myViewHolder.index.setText(String.valueOf(position));

        return convertView;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        View firstChild = view.getChildAt(0);
        if (firstChild == null) return;
        int top = firstChild.getTop();
        isScrollUp = firstVisibleItem > mLastFirstVisibleItem || mFirstTop > top;
        mFirstTop = top;
        mLastFirstVisibleItem = firstVisibleItem;
    }

    private final static class MyViewHolder {
        public AppCompatImageView imageView;
        public AppCompatTextView index;
    }
}
