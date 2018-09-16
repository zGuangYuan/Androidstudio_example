package com.example.yuan.e06_gridview.Intent;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yuan.e05_listview.R;

public class SecondActivity extends AppCompatActivity {

    private TextView mRecivedate1;
    private Button mBackButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //获取控件实例
        mRecivedate1 = (TextView) findViewById(R.id.IntentDate_Id1);
        mBackButton = (Button) findViewById(R.id.Intent_BackId);
        //使用Bundle对象接受数据
        Bundle bundle =getIntent().getExtras();
        String name = bundle.getString("name");
        int age = bundle.getInt("age");
        mRecivedate1.setText("name:"+name+","+"  age:"+age);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //新建一个Intent对象
                Intent intent = new Intent();
                //生成一个Bundle对象
                Bundle bundle1 =new Bundle();
                //放置数据
                bundle1.putString("result","真");
                bundle1.putInt("data",6666);
                intent.putExtras(bundle1);
                //返回Intent对象
                setResult(Activity.RESULT_OK,intent);
                //关闭当前的Activity
                finish();
            }
        });

    }
}
