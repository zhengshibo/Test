package test.ibaokang.com.test.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import test.ibaokang.com.test.R;

/**
 * Created by shibo.zheng on 2017/6/16.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Map<String, Object>> lists;
    private Context mContext;

    /*private int[] icon = {R.drawable.class1, R.drawable.class2, R.drawable.class3, R.drawable.class4, R.drawable.class5, R.drawable.class6};
    private String[] title = {"签到", "签到", "签到", "签到", "签到", "签到"};*/
    private int[] top_icon = {R.drawable.wallpager1, R.drawable.wallpager2, R.drawable.wallpager3, R.drawable.wallpager4};
    private String[] top_title = {"头条一","头条二","头条三","头条四"};
    private static enum ITEM_TYPE {//枚举 每种布局type
        ITEM_TYPE_TOP,//最新
        ITEM_TYPE_CLASS,//分类
        ITEM_TYPE_RECOMMEND,//推荐
        ITEM_TYPE_NEW,//新闻
        ITEM_TYPE_DISCOUNT,//折扣
        ITEM_TYPE_REMIND//提醒
    }

    public RecyclerAdapter(Context context, List lists) {
        this.lists = lists;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        RecyclerView.ViewHolder holder = null;
        switch (viewType) {
            case 0:
                view = LayoutInflater.from(mContext).inflate(R.layout.city_test, parent, false);
                holder =  new TodayTopViewHolder(view);
                break;
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_class_list, parent, false);
                holder =  new ClassListViewHolder(view);
                break;
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recommend, parent, false);
                holder =  new RecommendViewHolder(view);
                break;
            case 3:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_list, parent, false);
                holder =  new NewListViewHolder(view);
                break;
            case 4:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discount, parent, false);
                holder =  new DiscountViewHolder(view);
                break;
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_remind, parent, false);
                holder = new RemindViewHolder(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TodayTopViewHolder) {
//            ((TodayTopViewHolder) holder).mCityTopTextView.setText("携号转网");
        } else if (holder instanceof ClassListViewHolder) {

        } else if (holder instanceof RecommendViewHolder) {

        } else if (holder instanceof NewListViewHolder) {

        } else if (holder instanceof DiscountViewHolder) {

        } else if (holder instanceof RemindViewHolder) {

        } else {

        }
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    @Override
    public int getItemViewType(int position) {
        int type;
        switch (position) {
            case 0:
                type = ITEM_TYPE.ITEM_TYPE_TOP.ordinal();
                break;
            case 1:
                type = ITEM_TYPE.ITEM_TYPE_CLASS.ordinal();
                break;
            case 2:
                type = ITEM_TYPE.ITEM_TYPE_RECOMMEND.ordinal();
                break;
            case 3:
                type = ITEM_TYPE.ITEM_TYPE_NEW.ordinal();
                break;
            case 4:
                type = ITEM_TYPE.ITEM_TYPE_REMIND.ordinal();
                break;
            default:
                type = ITEM_TYPE.ITEM_TYPE_DISCOUNT.ordinal();
                break;
        }
        return type;
    }

    public class TodayTopViewHolder extends RecyclerView.ViewHolder{
        private TextView mCityTopTextView;
        public TodayTopViewHolder(View itemView) {
            super(itemView);
            mCityTopTextView = (TextView) itemView.findViewById(R.id.textLeft);
        }
    }

    public class ClassListViewHolder extends RecyclerView.ViewHolder {
        public ClassListViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class RecommendViewHolder extends RecyclerView.ViewHolder {
        public RecommendViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class NewListViewHolder extends RecyclerView.ViewHolder {
        public NewListViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class DiscountViewHolder extends RecyclerView.ViewHolder {
        public DiscountViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class RemindViewHolder extends RecyclerView.ViewHolder {
        public RemindViewHolder(View itemView) {
            super(itemView);
        }
    }

    /*
     * 获取分类数据源；
     *//*
    public List<Map<String, Object>> getClassData() {//将图片和文字放入集合中;
        List<Map<String, Object>> list1 = new ArrayList();
        for (int i = 0; i < icon.length; i++) {
            Map map1 = new HashMap<String, Object>();
            map1.put("class_img", icon[i]);
            map1.put("class_txt", title[i]);
            list1.add(map1);
        }
        return list1;
    }*/

/*    *//*
     * 获取今日头条数据源；
     *//*
    public List<Map<String, Object>> getTopData() {//将图片和文字放入集合中;
        List<Map<String, Object>> list2 = new ArrayList();
        for (int i = 0; i < top_icon.length; i++) {
            Map map2 = new HashMap<String, Object>();
            map2.put("top_img", top_icon[i]);
            map2.put("top_txt", top_title[i]);
            list2.add(map2);
        }
        return list2;
    }*/
}
