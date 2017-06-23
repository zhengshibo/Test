package test.ibaokang.com.test.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import test.ibaokang.com.test.R;
import test.ibaokang.com.test.fragment.CityFragment;
import test.ibaokang.com.test.fragment.HomeFragment;
import test.ibaokang.com.test.fragment.MessageFragment;
import test.ibaokang.com.test.fragment.PersonFragment;
import test.ibaokang.com.test.tabbar.MainNavigateTabBar;

public class MainActivity extends BaseActivity {

    private static final String TAG_PAGE_HOME = "首页";
    private static final String TAG_PAGE_CITY = "同城";
    private static final String TAG_PAGE_PUBLISH = "发布";
    private static final String TAG_PAGE_MESSAGE = "消息";
    private static final String TAG_PAGE_PERSON = "我的";

    private long exitTime = 0;
    private MainNavigateTabBar mNavigateTabBar;
    private ImageView mAddButtom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNavigateTabBar.onRestoreInstanceState(savedInstanceState);
        mNavigateTabBar.addTab(HomeFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.comui_tab_home, R.mipmap.comui_tab_home_selected, TAG_PAGE_HOME));
        mNavigateTabBar.addTab(CityFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.comui_tab_city, R.mipmap.comui_tab_city_selected, TAG_PAGE_CITY));
        mNavigateTabBar.addTab(null, new MainNavigateTabBar.TabParam(0, 0, TAG_PAGE_PUBLISH));
        mNavigateTabBar.addTab(MessageFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.comui_tab_message, R.mipmap.comui_tab_message_selected, TAG_PAGE_MESSAGE));
        mNavigateTabBar.addTab(PersonFragment.class, new MainNavigateTabBar.TabParam(R.mipmap.comui_tab_person, R.mipmap.comui_tab_person_selected, TAG_PAGE_PERSON));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mNavigateTabBar.onSaveInstanceState(outState);
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.tab_post_icon:
                showToast("发布");
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
        return R.layout.activity_main;
    }

    @Override
    public void initView(View view) {
        mNavigateTabBar = (MainNavigateTabBar) findViewById(R.id.mainTabBar);
        mAddButtom = (ImageView) findViewById(R.id.tab_post_icon);
    }

    @Override
    public void setListener() {
        mAddButtom.setOnClickListener(this);
    }

    @Override
    public void doBusiness(Context mContext) {
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
