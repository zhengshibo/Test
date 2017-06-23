package test.ibaokang.com.test.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;


import java.util.ArrayList;
import java.util.List;

import test.ibaokang.com.test.R;
import test.ibaokang.com.test.util.IbaoKangUtils;
import test.ibaokang.com.test.util.SharePrefereUtils;

public class GuideActivity extends BaseActivity{
    private ViewPager guideViewPager;
    private ImageView first, second, third;
    private ArrayList<View> guideView = new ArrayList<View>();
    private List mlist;

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.third:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                SharePrefereUtils.setNotFirstStart(getApplicationContext());
                finish();
            default:
                break;
        }
    }

    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public View bindView() {
        return null;
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_guide;
    }

    @Override
    public void initView(View view) {
        guideViewPager = (ViewPager) findViewById(R.id.guideViewPager);
        View firstView = LayoutInflater.from(this).inflate(R.layout.guide_first, null);
        View secondView = LayoutInflater.from(this).inflate(R.layout.guide_second, null);
        View thirdView = LayoutInflater.from(this).inflate(R.layout.guide_third, null);
        first = (ImageView) firstView.findViewById(R.id.first);
        second = (ImageView) secondView.findViewById(R.id.second);
        third = (ImageView) thirdView.findViewById(R.id.third);
        guideView.add(firstView);
        guideView.add(secondView);
        guideView.add(thirdView);

        mlist = new ArrayList();
        mlist.add(findViewById(R.id.dot1));
        mlist.add(findViewById(R.id.dot2));
        mlist.add(findViewById(R.id.dot3));
    }

    @Override
    public void setListener() {
        third.setOnClickListener(this);
    }

    public void setWindow() {
        //设置图片的宽度充满屏幕，高度自定义（但是高度可能会被拉伸）
        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        int imageWidth = display.getWidth();
        int imageHeight = display.getHeight();
        first.setScaleType(ImageView.ScaleType.FIT_XY);
        first.setLayoutParams(new LinearLayout.LayoutParams(imageWidth, imageHeight));
        second.setScaleType(ImageView.ScaleType.FIT_XY);
        second.setLayoutParams(new LinearLayout.LayoutParams(imageWidth, imageHeight));
        third.setScaleType(ImageView.ScaleType.FIT_XY);
        third.setLayoutParams(new LinearLayout.LayoutParams(imageWidth, imageHeight));
    }

    public void setAdapter() {
        guideViewPager.setAdapter(new PagerAdapter() {
            //viewpager中的组件数量
            @Override
            public int getCount() {
                return guideView.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            //滑动切换的时候销毁当前的组件
            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(guideView.get(position));
            }

            //每次滑动的时候生成的组件
            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ((ViewPager) container).addView(guideView.get(position));
                return guideView.get(position);
            }
        });
    }

    //设置滑动监听
    public void setViewPagerListener() {
        guideViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            private int oldpasition = 0;

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ((View) mlist.get(oldpasition)).setBackground(getResources().getDrawable(R.drawable.main_point_black));
                ((View) mlist.get(position)).setBackground(getResources().getDrawable(R.drawable.main_point_yello));
                oldpasition = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void doBusiness(Context mContext) {
        setWindow();
//        IbaoKangUtils.hideBottomUIMenu(this);
        setAdapter();
        setViewPagerListener();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}
