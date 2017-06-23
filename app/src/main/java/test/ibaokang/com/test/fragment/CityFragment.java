package test.ibaokang.com.test.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.ibaokang.com.test.R;
import test.ibaokang.com.test.activity.BaseFragment;
import test.ibaokang.com.test.adapter.RecyclerAdapter;


/**
 * User:Shine
 * Date:2015-10-20
 * Description:
 */
public class CityFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private RecyclerAdapter adapter;
    private int[] icon = {R.drawable.class1, R.drawable.class2, R.drawable.class3, R.drawable.class4, R.drawable.class5, R.drawable.class6};
    private String[] title = {"签到", "签到", "签到", "签到", "签到", "签到"};
    private int[] top_icon = {R.drawable.wallpager1, R.drawable.wallpager2, R.drawable.wallpager3, R.drawable.wallpager4};
    private String[] top_title = {"头条一", "头条二", "头条三", "头条四"};

    @Override
    public int bindLayout() {
        return R.layout.fragment_city;
    }

    @Override
    public void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), OrientationHelper.VERTICAL, false));
        adapter = new RecyclerAdapter(getContext(), getTopData());
    }

    @Override
    public void doBusiness(Context mContext) {
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void widgetClick(View v) {

    }

    /*
     * 获取分类数据源；
     */
    public List<Map<String, Object>> getClassData() {//将图片和文字放入集合中;
        List<Map<String, Object>> list1 = new ArrayList();
        for (int i = 0; i < icon.length; i++) {
            Map map1 = new HashMap<String, Object>();
            map1.put("class_img", icon[i]);
            map1.put("class_txt", title[i]);
            list1.add(map1);
        }
        return list1;
    }

    /*
     * 获取今日头条数据源；
     */
    public List<Map<String, Object>> getTopData() {//将图片和文字放入集合中;
        List<Map<String, Object>> list2 = new ArrayList();
        for (int i = 0; i < top_icon.length; i++) {
            Map map2 = new HashMap<String, Object>();
            map2.put("top_img", top_icon[i]);
            map2.put("top_txt", top_title[i]);
            list2.add(map2);
        }
        return list2;
    }
}
