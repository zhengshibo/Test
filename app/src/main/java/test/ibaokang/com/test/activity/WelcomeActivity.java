package test.ibaokang.com.test.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

import test.ibaokang.com.test.R;
import test.ibaokang.com.test.util.IbaoKangUtils;
import test.ibaokang.com.test.util.SharePrefereUtils;


public class WelcomeActivity extends BaseActivity {
    @Override
    public void widgetClick(View v) {

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
        return R.layout.activity_welcome;
    }

    @Override
    public void initView(View view) {
        IbaoKangUtils.hideBottomUIMenu(this);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void doBusiness(Context mContext) {
        boolean firstStart = SharePrefereUtils.isFirstStart(mContext);
        if (firstStart) {
            showGuide();
        } else {
            startIbaokang();
        }
    }

    private void showGuide() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this,GuideActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }

    private void startIbaokang() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
