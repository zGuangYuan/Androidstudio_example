package com.example.yuan.e06_gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.yuan.e05_listview.R;

public class ImageViewActivity extends AppCompatActivity {

    private ImageView mIV1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        mIV1=(ImageView) findViewById(R.id.IV_1_Id);
        Glide.with(this).load("http://himg2.huanqiu.com/attachment2010/2016/0502/20160502090118966.jpg").into(mIV1);
    }
}
