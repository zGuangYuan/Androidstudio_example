package com.example.yuan.e06_gridview.RecycleView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.yuan.e05_listview.R;

public class RecycleViewActivity extends AppCompatActivity {

    //声明引用
    private Button mLinearButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        //获取控件对象
        mLinearButton=(Button) findViewById(R.id.button_linearRV_Id);
        setlistener();
    }
    public void setlistener(){
        //生成监听器对象
        ButtonListener listener = new ButtonListener();
        //绑定监听器
        mLinearButton.setOnClickListener(listener);
    }
    class ButtonListener implements OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent =null;
            switch(v.getId()){
                case R.id.button_linearRV_Id:
                    intent = new Intent(RecycleViewActivity.this,LinearRecycleViewActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
