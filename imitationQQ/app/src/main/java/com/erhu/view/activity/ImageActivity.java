package com.erhu.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.erhu.view.base.ActivityBase;
import com.erhu.view.data.ConstantPhoto;
import com.erhu.view.loading.ImageDialog;
import com.example.administrator.imitationqq.R;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016/6/12.
 */
public class ImageActivity extends ActivityBase {
    @BindView(R.id.headPortrait)
    Button headPortrait;
    @BindView(R.id.dialog)
    ImageView dialog;
    @BindView(R.id.nickname)
    EditText nickname;
    @BindView(R.id.reservoir)
    Button reservoir;
    @BindView(R.id.username)
    TextView username;
    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.men)
    RadioButton menRB;
    @BindView(R.id.woman)
    RadioButton womanRB;


    public static final int REQUEST_CODE_CAPTURE_CAMEIA = 19;
    public static final int REQUEST_CODE_PICK_IMAGE = 20;
    public String capturePath = null;
    Bitmap bitmap;
    public Uri uri;
    String mSickname;
    String Sickname;
    String mSsername;
    String mlocation;
    int type = 0;

    @Override
    public int getContentViewId() {
        return R.layout.fiagment1_dialog;
    }

    @Override
    protected void initViews(Bundle bundle) {
        listSharedPreferences();

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.men:
                        menRB.setChecked(true);
                        type = 1;
                        break;
                    case R.id.woman:
                        type = 2;
                        Toast.makeText(ImageActivity.this, "女" + mlocation, Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });

    }

    @OnClick({R.id.dialog, R.id.headPortrait, R.id.nickname, R.id.reservoir, R.id.rg})
    void click(View v) {
        switch (v.getId()) {
            case R.id.dialog:
                break;
            case R.id.headPortrait:
                initDialog();
                break;
            case R.id.reservoir:
                mSickname = nickname.getText().toString().trim();
                SharedPreferences sharedPreferences = getSharedPreferences("pensen", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Sickname", mSickname);
                editor.putString("nickname", mlocation);
                editor.putInt("sex", type);
                editor.commit();
                finish();
                break;
        }
    }

    private void initDialog() {
        final ImageDialog dialog = new ImageDialog(ImageActivity.this);
        dialog.show();
        dialog.setListener(new ImageDialog.ButtonOnClick() {
            @Override
            public void photo() {
                getPicCamera();
                dialog.dismiss();
            }

            @Override
            public void upload() {
                getPicPtoto();
                dialog.dismiss();
            }
        });
    }

    public void getPicCamera() {
        //获得sd卡的状态  返回时一个String 类型状态量
        String state = Environment.getExternalStorageState();
        //判断是否有读写权限  没有则提示
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            Intent getImageByCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            //获得对象的属性
            String out_file_path = ConstantPhoto.SAVED_IMAGE_DIR_PATH;
            //创建档案类的实例   构建新的档案路径
            File dir = new File(out_file_path);
            // 判断能否检测到sd卡的文件  不能 则创建档案目录  能则 传递给img
            if (!dir.exists()) {
                dir.mkdirs();
            }
            capturePath = ConstantPhoto.SAVED_IMAGE_DIR_PATH + System.currentTimeMillis() + ".jpg";
            uri = Uri.fromFile(new File(capturePath));
            getImageByCamera.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            getImageByCamera.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
            startActivityForResult(getImageByCamera, REQUEST_CODE_CAPTURE_CAMEIA);
        } else {
            Toast.makeText(getApplicationContext(), "请确认已经插入SD卡", Toast.LENGTH_LONG).show();
        }
    }
    private void getPicPtoto() {
        Intent intent = new Intent(Intent.ACTION_PICK);//参数是用户自己选择数据
        intent.setType("image/*");//相片类型
        startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE);
    }

    @Override//请求码，结果码，数据
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE_PICK_IMAGE) {
                Uri uri = data.getData();
                bitmap = getBitmapFromUri(uri);
                dialog.setImageBitmap(bitmap);
            } else if (requestCode == REQUEST_CODE_CAPTURE_CAMEIA) {
                if (uri == null) {
                    Bundle bundle = data.getExtras();
                    if (bundle != null) {
                        Bitmap photo = (Bitmap) bundle.get("data"); //get bitmap
                        dialog.setImageBitmap(bitmap);
                        String spath = "erhu";
                        saveImage(photo, spath);
                    } else {
                        Toast.makeText(getApplicationContext(), "err****", Toast.LENGTH_LONG).show();
                        return;
                    }
                } else {
                    bitmap = getBitmapFromUri(uri);
                    dialog.setImageBitmap(bitmap);
                }
            }
        }
    }

    public static void saveImage(Bitmap photo, String spath) {
        try {
            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream(spath, false));
            photo.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Bitmap getBitmapFromUri(Uri uri) {
        // 读取uri所在的图片
        Bitmap bitmap = null;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return bitmap;
    }
    public void listSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences("pensen", Context.MODE_PRIVATE);
        Sickname = sharedPreferences.getString("Sickname", "");
        mSsername = sharedPreferences.getString("Ssername", "");
        int type=sharedPreferences.getInt("sex", 0);
        nickname.setText(Sickname);
        username.setText(mSsername);
        if (type==1){
            menRB.setChecked(true);}else {
           womanRB.setChecked(true);
        }
        Toast.makeText(ImageActivity.this, "我是获得的注册昵称Sickname", Toast.LENGTH_LONG).show();
    }
}
