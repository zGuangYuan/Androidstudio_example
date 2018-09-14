package com.example.yuan.e06_gridview.GridView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.yuan.e05_listview.R;
import com.example.yuan.e06_gridview.MainActivity;

public class GridViewActivity extends AppCompatActivity {

    //声明引用
    private GridView mGV1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        mGV1=(GridView) findViewById(R.id.GV_1_Id);
        mGV1.setAdapter(new MyGridViewAdapter(GridViewActivity.this));

        //为GridView设置监听器
        mGV1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //设置一个弹窗Toast,显示被短点击的条目
                Toast.makeText(GridViewActivity.this,"点击位置:"+position,Toast.LENGTH_SHORT).show();
            }
        });
        mGV1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                //设置一个弹窗Toast,显示被短点击的条目
                Toast.makeText(GridViewActivity.this,"长按位置:"+position,Toast.LENGTH_SHORT).show();
                if(position == 0){
                    Intent intent =new Intent(GridViewActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                return false;
            }
        });
    }
}
