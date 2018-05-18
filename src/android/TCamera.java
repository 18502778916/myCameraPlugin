package com.jinan.mycamera;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;


import me.zhouzhuo810.cameracardcrop.CameraConfig;
import me.zhouzhuo810.cameracardcrop.CropActivity;

public class TCamera extends Activity {
    
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.t_camera);
        takePhoto();
    }
    
    public void takePhoto() {
        Intent intent = new Intent(TCamera.this, CropActivity.class);
        intent.putExtra(CameraConfig.RATIO_WIDTH, 855);
        intent.putExtra(CameraConfig.RATIO_HEIGHT, 541);
        intent.putExtra(CameraConfig.PERCENT_WIDTH, 0.8f);
        intent.putExtra(CameraConfig.MASK_COLOR, 0x2f000000);
        intent.putExtra(CameraConfig.RECT_CORNER_COLOR, 0xff00ff00);
        intent.putExtra(CameraConfig.TEXT_COLOR, 0xffffffff);
        intent.putExtra(CameraConfig.HINT_TEXT, "请将方框对准证件拍照");
        intent.putExtra(CameraConfig.IMAGE_PATH, Environment.getExternalStorageDirectory().getAbsolutePath()+"/CameraCardCrop/"+System.currentTimeMillis()+".jpg");
        startActivityForResult(intent, 0x02);
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 0x02) {
                String path = data.getStringExtra(CameraConfig.IMAGE_PATH);
                // iv1.setImageURI(Uri.parse("file://"+path));
                Intent intent=new Intent();
                intent.putExtra("result",path);
                setResult(RESULT_OK,intent);
                finish();
            }
        }else {
            finish();
        }
    }
}
