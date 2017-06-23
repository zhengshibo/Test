package test.ibaokang.com.test.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import test.ibaokang.com.test.R;

/**
 * Created by shibo.zheng on 2017/4/11.
 */

public class Title extends LinearLayout {
    private ImageView back;
    private TextView titleName;
    private int title_back;
    private String title_name;

    public Title(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.title, this);
        back = (ImageView) view.findViewById(R.id.back);
        titleName = (TextView) view.findViewById(R.id.title_name);

        TypedArray t = context.obtainStyledAttributes(attrs, R.styleable.Title);
        title_back = t.getResourceId(R.styleable.Title_title_img, -1);
        title_name = t.getString(R.styleable.Title_title_name);
        init();
        t.recycle();
    }

    private void init() {
        setImageResource(title_back);
        setTitleName(title_name);
        isShow(true);
    }

    public void setImageResource(int resId) {
        back.setImageResource(resId);
    }

    public void setTitleName(String text) {
        titleName.setText(text);
    }

    public void isShow(boolean show) {
        setVisibility(show ? VISIBLE : GONE);
    }
}
