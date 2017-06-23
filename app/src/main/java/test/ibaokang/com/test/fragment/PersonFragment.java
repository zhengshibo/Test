package test.ibaokang.com.test.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import test.ibaokang.com.test.R;
import test.ibaokang.com.test.activity.BaseFragment;
import test.ibaokang.com.test.activity.ChooseUserPhoto;
import test.ibaokang.com.test.activity.LoginActivity;


/**
 * User:Shine
 * Date:2015-10-20
 * Description:
 */
public class PersonFragment extends BaseFragment {
    private TextView mUserName;
    private CircleImageView mUserHead;

    @Override
    public int bindLayout() {
        return R.layout.fragment_person;
    }

    @Override
    public void initView(View view) {
        mUserHead = (CircleImageView) view.findViewById(R.id.imageview);
        mUserName = (TextView) view.findViewById(R.id.username);
        mUserHead.setOnClickListener(this);
        mUserName.setOnClickListener(this);
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()){
            case R.id.imageview:
                Intent intent = new Intent(getContext(),ChooseUserPhoto.class);
                startActivity(intent);
                break;
            case R.id.username:
                Intent intent_login = new Intent(getContext(),LoginActivity.class);
                startActivity(intent_login);
                break;
        }
    }
}
