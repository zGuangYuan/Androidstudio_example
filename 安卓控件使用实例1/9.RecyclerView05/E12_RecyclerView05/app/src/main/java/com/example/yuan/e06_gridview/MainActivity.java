package com.example.yuan.e06_gridview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.yuan.e06_gridview.GridView.GridViewActivity;
import com.example.yuan.e06_gridview.ListView.ListViewActivity;
import com.example.yuan.e05_listview.R;


public class MainActivity extends AppCompatActivity {
    //声明引用
    private Button mIVButton;
    private Button mLVButton;
    private Button mGVButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取控件对象
        mIVButton=(Button) findViewById(R.id.IVButton_Id);
        mLVButton=(Button) findViewById(R.id.LVButton_Id);
        mGVButton=(Button) findViewById(R.id.GVButton_Id);
        setlistener();
    }
    //设置监听器
    public void setlistener(){
        ButtonClickListener listener =new ButtonClickListener();
        mLVButton.setOnClickListener(listener);
        mIVButton.setOnClickListener(listener);
        mGVButton.setOnClickListener(listener);
    }
    //实现监听器接口
    class ButtonClickListener implements OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.GVButton_Id:
                    intent=new Intent(MainActivity.this, GridViewActivity.class);
                    break;
                case R.id.IVButton_Id:
                    intent = new Intent(MainActivity.this,ImageViewActivity.class);
                    break;
                case R.id.LVButton_Id:
                    intent =new Intent(MainActivity.this, ListViewActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
