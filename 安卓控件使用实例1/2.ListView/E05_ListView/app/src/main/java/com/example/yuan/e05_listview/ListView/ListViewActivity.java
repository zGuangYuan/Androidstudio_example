package com.example.yuan.e05_listview.ListView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.yuan.e05_listview.MainActivity;
import com.example.yuan.e05_listview.R;

import static android.widget.AdapterView.*;

public class ListViewActivity extends AppCompatActivity {

    private ListView mLV1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        //获取控件对象
        mLV1=(ListView) findViewById(R.id.lv_1_Id);
        //设置一个设配器，最重要的一个方法
        mLV1.setAdapter(new MyAdapter(ListViewActivity.this));
        //为ListView设置监听器
        mLV1.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //设置一个弹窗，显示是哪个被点击了
                Toast.makeText(ListViewActivity.this,"点击位置"+position,Toast.LENGTH_SHORT).show();
            }
        });
        mLV1.setOnItemLongClickListener(new OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //设置一个弹窗，显示是哪个被点击了
                Toast.makeText(ListViewActivity.this,"长按位置"+position,Toast.LENGTH_SHORT).show();
                if(position ==0) {
                    Intent intent = new Intent(ListViewActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                return true;
            }
        });

    }
}
