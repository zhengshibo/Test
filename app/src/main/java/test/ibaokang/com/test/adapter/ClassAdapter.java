package test.ibaokang.com.test.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

import test.ibaokang.com.test.R;

/**
 * Created by shibo.zheng on 2017/6/14.
 */

public class ClassAdapter extends TestBaseAdapter<Map<String, Object>,ClassAdapter.TypeClassViewHolder> {

    public ClassAdapter(Context context, List<Map<String, Object>> data) {
        super(context, data);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.class_list_layout;
    }

    @Override
    protected TypeClassViewHolder createViewHolder(View itemView) {
        return new TypeClassViewHolder(itemView);
    }

    @Override
    protected void itemData(int position, Map<String, Object> stringObjectMap, TypeClassViewHolder viewHolder) {
        viewHolder.classImageView.setImageResource((int) stringObjectMap.get("class_img"));
        viewHolder.classTextView.setText((String) stringObjectMap.get("class_txt"));
    }

    public class TypeClassViewHolder extends BaseViewHolder {
        private ImageView classImageView;
        private TextView classTextView;

        public TypeClassViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void initViews(View itemView) {
            classImageView = (ImageView) itemView.findViewById(R.id.class_imgview);
            classTextView = (TextView) itemView.findViewById(R.id.class_textview);
        }
    }
}
