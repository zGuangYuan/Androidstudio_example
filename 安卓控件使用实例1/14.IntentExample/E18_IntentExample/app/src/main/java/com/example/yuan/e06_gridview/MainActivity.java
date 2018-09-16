package com.example.yuan.e06_gridview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.yuan.e06_gridview.Alertdialog.DiaglogActivity;
import com.example.yuan.e06_gridview.GridView.GridViewActivity;
import com.example.yuan.e06_gridview.Intent.FirstActivity;
import com.example.yuan.e06_gridview.ListView.ListViewActivity;
import com.example.yuan.e05_listview.R;
import com.example.yuan.e06_gridview.PoupWindow.PoupWindowActivity;
import com.example.yuan.e06_gridview.RecycleView.RecycleViewActivity;
import com.example.yuan.e06_gridview.Toast.ToastActivity;
import com.example.yuan.e06_gridview.WebView.WebViewActivity;


public class MainActivity extends AppCompatActivity {
    //声明引用
    private Button mIVButton;
    private Button mLVButton;
    private Button mGVButton;
    private Button mRVButton;
    private Button mWVButton;
    private Button mToastButton,mDiaglogButton,mPoupWinowButton,mIntentButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取控件对象
        mIVButton=(Button) findViewById(R.id.IVButton_Id);
        mLVButton=(Button) findViewById(R.id.LVButton_Id);
        mGVButton=(Button) findViewById(R.id.GVButton_Id);
        mRVButton=(Button) findViewById(R.id.RVButton_Id);
        mWVButton=(Button) findViewById(R.id.WVButton_Id);
        mToastButton=(Button)findViewById(R.id.ToastButton_Id);
        mDiaglogButton=(Button) findViewById(R.id.DiaglogButton_Id);
        mPoupWinowButton=(Button) findViewById(R.id.PoupWindowButton_Id);
        mIntentButton=(Button) findViewById(R.id.IntentButton_Id);
        setlistener();
    }
    //设置监听器
    public void setlistener(){
        ButtonClickListener listener =new ButtonClickListener();
        mLVButton.setOnClickListener(listener);
        mIVButton.setOnClickListener(listener);
        mGVButton.setOnClickListener(listener);
        mRVButton.setOnClickListener(listener);
        mWVButton.setOnClickListener(listener);
        mToastButton.setOnClickListener(listener);
        mDiaglogButton.setOnClickListener(listener);
        mPoupWinowButton.setOnClickListener(listener);
        mIntentButton.setOnClickListener(listener);
    }
    //实现监听器接口
    class ButtonClickListener implements OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.ToastButton_Id:
                    intent = new Intent(MainActivity.this, ToastActivity.class);
                    break;
                case R.id.GVButton_Id:
                    intent=new Intent(MainActivity.this, GridViewActivity.class);
                    break;
                case R.id.IVButton_Id:
                    intent = new Intent(MainActivity.this,ImageViewActivity.class);
                    break;
                case R.id.LVButton_Id:
                    intent =new Intent(MainActivity.this, ListViewActivity.class);
                    break;
                case R.id.RVButton_Id:
                    intent = new Intent(MainActivity.this, RecycleViewActivity.class);
                    break;
                case R.id.WVButton_Id:
                    intent =new Intent(MainActivity.this, WebViewActivity.class);
                    break;
                    //跳转到Diaglog演示界面
                case R.id.DiaglogButton_Id:
                    intent = new Intent(MainActivity.this, DiaglogActivity.class);
                    //跳转到Poupwindow的演示界面
                case R.id.PoupWindowButton_Id:
                    intent = new Intent(MainActivity.this, PoupWindowActivity.class);
                    break;
                    //跳转到Intent演示界面：
                case R.id.IntentButton_Id:
                    intent = new Intent(MainActivity.this, FirstActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
