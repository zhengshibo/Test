package test.ibaokang.com.test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by shibo.zheng on 2017/6/19.
 */

public abstract class TestBaseAdapter<T, E extends BaseViewHolder> extends BaseAdapter {
    private LayoutInflater mInflater;
    private Context mContext;
    private List<T> mDatas;

    public TestBaseAdapter(Context context, List<T> data) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mDatas = data;
    }

    @Override
    public int getCount() {
        return mDatas == null ? 0 : mDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return mDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        E viewHolder = null;
        if (view == null) {
            view = mInflater.inflate(getLayoutID(), viewGroup, false);
            viewHolder =createViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (E) view.getTag();
        }
        itemData(i, mDatas.get(i), viewHolder);
        return view;
    }

    protected abstract int getLayoutID();

    protected abstract E createViewHolder(View itemView);

    protected abstract void itemData(int position, T t, E viewHolder);

}
