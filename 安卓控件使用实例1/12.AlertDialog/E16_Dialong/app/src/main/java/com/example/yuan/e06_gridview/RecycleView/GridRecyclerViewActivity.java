package com.example.yuan.e06_gridview.RecycleView;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.yuan.e05_listview.R;

public class GridRecyclerViewActivity extends AppCompatActivity {
    //声明引用
    private RecyclerView mGridRV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        //获取控件对象
        mGridRV=findViewById(R.id.RV_grid_Id);
        //设置RecylcerView布局管理器
        mGridRV.setLayoutManager(new GridLayoutManager(GridRecyclerViewActivity.this,3));
        //设置适配器
        //mGridRV.setAdapter();
        mGridRV.setAdapter(new GridRecyclerViewAdapter(GridRecyclerViewActivity.this));

    }

}
