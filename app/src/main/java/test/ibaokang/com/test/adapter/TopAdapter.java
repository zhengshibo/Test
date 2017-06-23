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

public class TopAdapter extends TestBaseAdapter<Map<String, Object>, TopAdapter.TypeTopViewHolder> {

    public TopAdapter(Context context, List<Map<String, Object>> data) {
        super(context, data);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.toady_top;
    }

    @Override
    protected TypeTopViewHolder createViewHolder(View itemView) {
        return new TypeTopViewHolder(itemView);
    }

    @Override
    protected void itemData(int position, Map<String, Object> stringIntegerMap, TypeTopViewHolder viewHolder) {
        viewHolder.topImageView.setImageResource((int) stringIntegerMap.get("top_img"));
        viewHolder.topTextView.setText((String) stringIntegerMap.get("top_txt"));
    }


    public class TypeTopViewHolder extends BaseViewHolder {
        private ImageView topImageView;
        private TextView topTextView;

        public TypeTopViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void initViews(View itemView) {
            topImageView = (ImageView) itemView.findViewById(R.id.top_imageview);
            topTextView = (TextView) itemView.findViewById(R.id.top_textview);
        }
    }
}
