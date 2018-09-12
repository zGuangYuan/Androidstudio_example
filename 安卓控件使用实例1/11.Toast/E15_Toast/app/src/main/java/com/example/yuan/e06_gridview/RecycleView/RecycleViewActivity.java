package com.example.yuan.e06_gridview.RecycleView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.yuan.e05_listview.R;
import com.example.yuan.e06_gridview.GridView.GridViewActivity;

public class RecycleViewActivity extends AppCompatActivity {

    //声明引用
    private Button mLinearButton;
    private Button mHorLinearButton;
    private Button mGridButton;
    private Button mWaterfallButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        //获取控件对象
        mLinearButton=(Button) findViewById(R.id.button_linearRV_Id);
        mHorLinearButton=(Button) findViewById(R.id.button_linearRV2_Id);
        mGridButton=(Button) findViewById(R.id.button_gridRV3_Id);
        mWaterfallButton=(Button) findViewById(R.id.button_waterfallRV4_Id);

        setlistener();
    }
    public void setlistener(){
        //生成监听器对象
        ButtonListener listener = new ButtonListener();
        //绑定监听器
        mLinearButton.setOnClickListener(listener);
        mHorLinearButton.setOnClickListener(listener);
        mGridButton.setOnClickListener(listener);
        mWaterfallButton.setOnClickListener(listener);
    }
    class ButtonListener implements OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent =null;
            switch(v.getId()){
                case R.id.button_linearRV_Id:
                    intent = new Intent(RecycleViewActivity.this,LinearRecycleViewActivity.class);
                    break;
                case R.id.button_linearRV2_Id:
                    intent = new Intent(RecycleViewActivity.this,HorLinearRecyclerViewActivity.class);
                    break;
                case R.id.button_gridRV3_Id:
                    intent = new Intent(RecycleViewActivity.this, GridRecyclerViewActivity.class);
                    break;
                case R.id.button_waterfallRV4_Id:
                    intent=new Intent(RecycleViewActivity.this,WaterfallRecyclerViewActivity.class);
            }
            startActivity(intent);
        }
    }
}
