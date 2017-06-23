package test.ibaokang.com.test.adapter;

import android.view.View;

/**
 * Created by shibo.zheng on 2017/6/19.
 */

public abstract class BaseViewHolder {
    public BaseViewHolder(View itemView) {
        initViews(itemView);
    }

    public abstract void initViews(View itemView);
}
