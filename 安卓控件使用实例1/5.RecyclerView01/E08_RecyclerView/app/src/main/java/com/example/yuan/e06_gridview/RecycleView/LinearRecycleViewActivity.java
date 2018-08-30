package com.example.yuan.e06_gridview.RecycleView;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.yuan.e05_listview.R;

public class LinearRecycleViewActivity extends AppCompatActivity {

    private RecyclerView mRVMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycle_view);

        mRVMain=(RecyclerView) findViewById(R.id.RV_main_Id);
        //设置线性布局管理器
        mRVMain.setLayoutManager(new LinearLayoutManager(LinearRecycleViewActivity.this));
        //Item装饰
        mRVMain.addItemDecoration(new MyDecoration());
        //设置Adapter
        mRVMain.setAdapter(new LinearAdapter(LinearRecycleViewActivity.this, new LinearAdapter.OnItemClickListener() {
            @Override
            public void OnClick(int position) {
                Toast.makeText(LinearRecycleViewActivity.this,"点击位置"+position,Toast.LENGTH_SHORT).show();
            }
        }));

        //继承ItemDecoration类

        }
        class MyDecoration extends RecyclerView.ItemDecoration{
        //复写getItemOffsets方法
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.dividerHeight));
        }
    }
}
