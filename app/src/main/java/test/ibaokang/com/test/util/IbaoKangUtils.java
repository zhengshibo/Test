package test.ibaokang.com.test.util;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Environment;
import android.view.View;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import test.ibaokang.com.test.activity.BaseActivity;

/**
 * Created by shibo.zheng on 2017/4/12.
 */

public class IbaoKangUtils {
    public static final String HEAD_PHOTOS_PATH = "/IbaoKang/icon_photo/";
    public static final String IMAGE_FILE_NAME = "user_image.jpg";
    public static final String HEAD_IMG_PATH = "/IbaoKang/icon_user/";
    public static final String HEAD_IMG_NAME = "myicon.jpg";

    public static void saveFile(Bitmap bm) throws IOException {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath().toString() + HEAD_IMG_PATH;
        File dirFile = new File(path);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        File myIconFile = new File(path + HEAD_IMG_NAME);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(myIconFile));
        bm.compress(Bitmap.CompressFormat.JPEG, 80, bos);
        bos.flush();
        bos.close();
    }

    /**
     * 隐藏虚拟按键，并且全屏
     */
    public static void hideBottomUIMenu(BaseActivity activity) {
        //隐藏虚拟按键，并且全屏
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = activity.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = activity.getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }
}
