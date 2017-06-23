package test.ibaokang.com.test.activity;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.File;

import test.ibaokang.com.test.R;
import test.ibaokang.com.test.util.IbaoKangUtils;

public class ChooseUserPhoto extends BaseActivity implements AdapterView.OnItemClickListener {
    private final int TO_TAKE_PHOTO = 1 << 2;
    private final int TO_GALLERY = 1 << 3;
    private final int CROP_PHOTO = 1 << 4;
    private View mViewContent;
    private boolean isEnableFinish = true;

    @Override
    public void widgetClick(View v) {
        if (!isEnableFinish) return;
        finish();
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
        return R.layout.activity_choose_img;
    }

    @Override
    public void initView(View view) {
        ListView mList = (ListView) findViewById(R.id.choose_header);
        mViewContent = findViewById(R.id.choose_content);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.choose_item);
        mList.setAdapter(adapter);
        adapter.addAll(getResources().getStringArray(R.array.check_photo));
        mList.setOnItemClickListener(this);
        view.setOnClickListener(this);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        isEnableFinish = false;
        Intent intent = null;
        mViewContent.postDelayed(new Runnable() {
            @Override
            public void run() {
                mViewContent.setVisibility(View.GONE);
            }
        }, 500);
        switch (position) {
            case 0:
                //检查权限
                if (hasPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)) {
                    intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, getImageUri());
                    intent.putExtra("return-data", true);
                    startActivityForResult(intent, TO_TAKE_PHOTO);
                } else {
                    requestPermission(11, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA);
                }
                break;
            case 1:
                intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, TO_GALLERY);
                break;
            default:
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        isEnableFinish = true;
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case TO_TAKE_PHOTO:
                    cropPhotos(getImageUri());
                    break;
                case TO_GALLERY:
                    cropPhotos(getImgPath(data.getData()));
                    break;
                case CROP_PHOTO:
                    try {
                        Uri uri = data.getData();
                        Bitmap bitmap = BitmapFactory.decodeStream(
                                getContentResolver().openInputStream(uri));
                        IbaoKangUtils.saveFile(bitmap);
                        Intent intent = getIntent();
                        intent.setData(uri);
                        setResult(RESULT_OK, intent);
                        finish();
                    } catch (Exception e) {
                    }
                    break;
                default:
                    break;
            }
        } else {
            finish();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void cropPhotos(Uri imageUri) {
        if (imageUri == null) {
            return;
        }
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(imageUri, "image/*");
        intent.putExtra("scale", true);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);

        intent.putExtra("outputX", 340);
        intent.putExtra("outputY", 340);
        startActivityForResult(intent, CROP_PHOTO);
    }
}
