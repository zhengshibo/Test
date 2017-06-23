package test.ibaokang.com.test.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import java.util.List;
import java.util.Map;

import test.ibaokang.com.test.R;

/**
 * Created by shibo.zheng on 2017/6/23.
 */

public class HomeRecyclerViewAdapter extends TestBaseAdapter<Map<String,Object>,HomeRecyclerViewAdapter.HomeRecyclerViewHolder> {

    public HomeRecyclerViewAdapter(Context context, List<Map<String, Object>> data) {
        super(context, data);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.city_test;
    }

    @Override
    protected HomeRecyclerViewHolder createViewHolder(View itemView) {
        return new HomeRecyclerViewHolder(itemView);
    }

    @Override
    protected void itemData(int position, Map<String, Object> stringObjectMap, HomeRecyclerViewHolder viewHolder) {

    }

    public class HomeRecyclerViewHolder extends BaseViewHolder{
        private ImageView home_top_title;
        public HomeRecyclerViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void initViews(View itemView) {

        }
    }
}
