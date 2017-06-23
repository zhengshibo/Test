package test.ibaokang.com.test.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by shibo.zheng on 2017/2/16.
 */

public class SharePrefereUtils {

    private static final String FIRST_START_PREF = "first_start_pref";
    private static final String FIRST_START_KEY = "first_start_key";

    public static boolean isFirstStart(Context context) {
        SharedPreferences firstStartPref = context.getSharedPreferences(FIRST_START_PREF, Context.MODE_PRIVATE);
        return firstStartPref.getBoolean(FIRST_START_KEY, true);
    }

    public static void setNotFirstStart(Context context) {
        SharedPreferences firstStartPref = context.getSharedPreferences(FIRST_START_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = firstStartPref.edit();
        editor.putBoolean(FIRST_START_KEY, false);
        editor.commit();
    }
}
