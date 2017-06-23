package test.ibaokang.com.test.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import test.ibaokang.com.test.R;

/**
 * Created by shibo.zheng on 2017/6/19.
 */

public class RecommendAdapter extends TestBaseAdapter<Map<String, Object>, RecommendAdapter.RecommendViewHolder> {

    public RecommendAdapter(Context context, List<Map<String, Object>> data) {
        super(context, data);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.recommend_item_layout;
    }

    @Override
    protected RecommendViewHolder createViewHolder(View itemView) {
        return new RecommendViewHolder(itemView);
    }

    @Override
    protected void itemData(int position, Map<String, Object> stringObjectMap, RecommendViewHolder viewHolder) {
        viewHolder.recommendImageView.setImageResource((int) stringObjectMap.get("recommend_img"));
        viewHolder.recommendTextView.setText((String) stringObjectMap.get("recommend_txt"));
    }

    public class RecommendViewHolder extends BaseViewHolder {
        private ImageView recommendImageView;
        private TextView recommendTextView;

        public RecommendViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void initViews(View itemView) {
            recommendImageView = (ImageView) itemView.findViewById(R.id.recommend_image);
            recommendTextView = (TextView) itemView.findViewById(R.id.recommend_txt);
        }
    }
}
