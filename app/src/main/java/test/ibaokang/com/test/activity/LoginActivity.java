package test.ibaokang.com.test.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import test.ibaokang.com.test.R;

public class LoginActivity extends BaseActivity {

    private ImageView back;
    private TextView title_name;
    private TextView mRegister, mForgetPwd;

    @Override
    public void widgetClick(View v) {
        switch (v.getId()){
            case R.id.back:
                finish();
                break;
            case R.id.register:
                startActivity(RegisterActivity.class);
                break;
            case R.id.forget_pwd:
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
        return R.layout.activity_login;
    }

    @Override
    public void initView(View view) {
        back = (ImageView) findViewById(R.id.back);
        title_name = (TextView) findViewById(R.id.title_name);
        mRegister = (TextView) view.findViewById(R.id.register);
        mForgetPwd = (TextView) view.findViewById(R.id.forget_pwd);
    }

    @Override
    public void setListener() {
        back.setOnClickListener(this);
        mRegister.setOnClickListener(this);
        mForgetPwd.setOnClickListener(this);
    }

    @Override
    public void doBusiness(Context mContext) {

    }
}
