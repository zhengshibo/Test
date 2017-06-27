package test.ibaokang.com.test.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.okhttp.Response;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.ibaokang.com.test.R;
import test.ibaokang.com.test.activity.BaseFragment;
import test.ibaokang.com.test.activity.LoginActivity;
import test.ibaokang.com.test.adapter.ClassAdapter;
import test.ibaokang.com.test.adapter.RecommendAdapter;
import test.ibaokang.com.test.adapter.TopAdapter;
import test.ibaokang.com.test.util.OkHttpUtils;


/**
 * User:Shine
 * Date:2015-10-20
 * Description:
 */
public class HomeFragment extends BaseFragment {

    private Banner banner;
    String[] titles = new String[]{"标题1", "标题2", "标题3"};
    int[] images = new int[]{R.drawable.wallpager1, R.drawable.wallpager2, R.drawable.wallpager3, R.drawable.wallpager4, R.drawable.wallpager5};
    List list = Arrays.asList(images);
    private ImageView mUserLogin;
    private LinearLayout TopTodayTitle;
    private LinearLayout RecommendTitle;
    private GridView mGridView;
    private GridView mTodayTop;
    private GridView mRecommend;
    private RecyclerView mRecyclerView;

    private String[] imageUrl = {"http://www.eoeandroid.com/data/attachment/forum/201107/18/142935bbi8d3zpf3d0dd7z.jpg",
            "http://www.eoeandroid.com/data/attachment/forum/201107/18/142935bbi8d3zpf3d0dd7z.jpg",
            "http://www.eoeandroid.com/data/attachment/forum/201107/18/142935bbi8d3zpf3d0dd7z.jpg"};
    private int[] icon = {R.drawable.class1, R.drawable.class2, R.drawable.class3, R.drawable.class4, R.drawable.class5, R.drawable.class6};
    private String[] title = {"签到", "签到", "签到", "签到", "签到", "签到"};

    private int[] top_icon = {R.drawable.wallpager1, R.drawable.wallpager2, R.drawable.wallpager3, R.drawable.wallpager4};
    private String[] top_title = {"头条一", "头条二", "头条三", "头条四"};

    private int[] recommend_icon = {R.drawable.wallpager1, R.drawable.wallpager2, R.drawable.wallpager3, R.drawable.wallpager4};
    private String[] recommend_title = {"推荐一", "推荐二", "推荐三", "推荐四"};

    @Override
    public int bindLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView(View view) {
        banner = (Banner) view.findViewById(R.id.banner);
        mUserLogin = (ImageView) view.findViewById(R.id.user_login);
        TopTodayTitle = (LinearLayout) view.findViewById(R.id.today_top_title);
//        RecommendTitle = (LinearLayout) view.findViewById(R.id.recommend_title);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.home_recycler);
        mGridView = (GridView) view.findViewById(R.id.gridView);
        mTodayTop = (GridView) view.findViewById(R.id.today_top);
//        mRecommend = (GridView) view.findViewById(R.id.recommend);
        TextView ToptextView = (TextView) TopTodayTitle.findViewById(R.id.setting_model_middle);
//        TextView RectextView = (TextView) RecommendTitle.findViewById(R.id.setting_model_middle);
        ToptextView.setText("今日头条");
//        RectextView.setText("特别推荐");
        mUserLogin.setOnClickListener(this);
    }

    @Override
    public void doBusiness(final Context mContext) {
        autoSlide();
        getAutoSlideUrl();
        ClassAdapter classAdapter = new ClassAdapter(getContext(), getClassData());
        TopAdapter topAdapter = new TopAdapter(getContext(), getTopData());
        RecommendAdapter recommendAdapter = new RecommendAdapter(getContext(),getRecommendData());

        mGridView.setAdapter(classAdapter);
        mTodayTop.setAdapter(topAdapter);
//        mRecommend.setAdapter(recommendAdapter);

        mGridView.setOnItemClickListener(new ItemClickListener());
        mTodayTop.setOnItemClickListener(new ItemClickListener());
    }

    @Override
    public void widgetClick(View v) {
        switch (v.getId()) {
            case R.id.user_login:
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        android.util.Log.d("zhengshibo", "initView  :  onStart ==>  ");
    }

    @Override
    public void onStop() {
        super.onStop();
        banner.isAutoPlay(false);
    }

    private void autoSlide() {//自动轮播
        banner.setDelayTime(3000);
        banner.setBannerTitles(Arrays.asList(titles));
        banner.setImages(Arrays.asList(imageUrl));
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.isAutoPlay(true);
        banner.start();
    }

    private void getAutoSlideUrl() {//通过网络获取图片URL
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    Response s = OkHttpUtils.getInstance().getAsyn("http://fengzone.applinzi.com/api/banner.php");
                    Log.d("zhengshibo", "HomeFragment :  string==>  " + s.body().string());
                } catch (IOException e) {
                    Log.d("zhengshibo", "HomeFragment :  string11==>  " + Log.getStackTraceString(e));
                    e.printStackTrace();
                }
            }
        }.start();
    }

    /*
     * 获取分类数据源；
     */
    public List<Map<String, Object>> getClassData() {//将图片和文字放入集合中
        List<Map<String, Object>> list1 = new ArrayList();
        for (int i = 0; i < icon.length; i++) {
            Map map = new HashMap<String, Object>();
            map.put("class_img", icon[i]);
            map.put("class_txt", title[i]);
            list1.add(map);
        }
        return list1;
    }

    /*
     * 获取今日头条数据源；
     */
    public List<Map<String, Object>> getTopData() {//将图片和文字放入集合中;
        List<Map<String, Object>> list2 = new ArrayList();
        for (int i = 0; i < top_icon.length; i++) {
            Map map = new HashMap<String, Object>();
            map.put("top_img", top_icon[i]);
            map.put("top_txt", top_title[i]);
            list2.add(map);
        }
        return list2;
    }

    /*
     * 获取特别推荐数据源；
     */
    public List<Map<String, Object>> getRecommendData() {//将图片和文字放入集合中;
        List<Map<String, Object>> list3 = new ArrayList();
        for (int i = 0; i < recommend_icon.length; i++) {
            Map map = new HashMap<String, Object>();
            map.put("recommend_img", recommend_icon[i]);
            map.put("recommend_txt", recommend_title[i]);
            list3.add(map);
        }
        return list3;
    }

    /*
     * 给每个item设置事件监听；
     */
    class ItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> arg0, View view, int id, long location) {
            // TODO Auto-generated method stub
            showToast("clicked me");
        }
    }
}
