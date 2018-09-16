package com.example.yuan.e06_gridview.PoupWindow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.yuan.e05_listview.R;
import com.example.yuan.e06_gridview.util.ToastUtil;

public class PoupWindowActivity extends AppCompatActivity {
    //声明引用
    private Button mPWButton;
    private PopupWindow mPoup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poup_window);
        //获取控件实体
        mPWButton = (Button) findViewById(R.id.PoupWindow_Id1);
//        PoupWindowListener listener =new PoupWindowListener();
//        mPWButton.setOnClickListener(listener);
        //设置点击事件
        mPWButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.PoupWindow_Id1){
                    //把layout_popwindow布局引荐引入到这个Activity
                    View view = getLayoutInflater().inflate(R.layout.layout_popwindow,null);
                    //设置PoupWindow的布局、宽度和按钮一致和高度包含内容
                    //获取控件对象
                    TextView goodtextView = (TextView) view.findViewById(R.id.TextView_goodId);
                    TextView sosotextView = (TextView) view.findViewById(R.id.TextView_sosoId);
                    TextView badtextView = (TextView) view.findViewById(R.id.TextView_badId);
                    goodtextView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ToastUtil.showMsg(getApplicationContext(),"很好");
                        }
                    });
                    sosotextView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ToastUtil.showMsg(getApplicationContext(),"一般");
                        }
                    });
                    badtextView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ToastUtil.showMsg(getApplicationContext(),"糟糕");
                        }
                    });

                    mPoup = new PopupWindow(view,mPWButton.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                    //点击外部的时候可以收回
                    mPoup.setOutsideTouchable(true);
                    //按键按一下收回，再按一次弹出
                    mPoup.setFocusable(true);
                    //显示在按钮的下面
                    mPoup.showAsDropDown(mPWButton);
                }
            }
        });
    }

}
