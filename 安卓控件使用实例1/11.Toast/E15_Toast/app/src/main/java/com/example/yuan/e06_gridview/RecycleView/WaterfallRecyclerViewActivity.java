package com.example.yuan.e06_gridview.RecycleView;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.yuan.e05_listview.R;

public class WaterfallRecyclerViewActivity extends AppCompatActivity {
    //声明引用
    private RecyclerView mWaterfallRV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waterfall_recycler_view);
        //获取控件对象
        mWaterfallRV=findViewById(R.id.RV_waterfall_Id);
        //设置布局管理器,两个参数，如果后面参数是垂直就代表第一个是几列，如果是水平，第一个就代表行数
        mWaterfallRV.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        //设置Adapter
        mWaterfallRV.setAdapter(new WaterfallRecyclerViewAdapter(WaterfallRecyclerViewActivity.this));
        //设置分割线
        mWaterfallRV.addItemDecoration(new MyDecoration());

    }
    class MyDecoration extends RecyclerView.ItemDecoration {
        //复写getItemOffsets方法
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            //设置距离为2dp
            int distance = getResources().getDimensionPixelOffset(R.dimen.pirtureDistance);
            //设置上下左右全部有2dp的分割线
            outRect.set(distance, distance, distance,distance);
        }
    }
}
