package com.example.yuan.e06_gridview.RecycleView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Toast;

import com.example.yuan.e05_listview.R;

public class HorLinearRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mhorRV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hor_linear_recycler_view);

        mhorRV=(RecyclerView) findViewById(R.id.RV_hor_Id);
        //设置一个线性布局管理器,因为要设置方向，就不采用匿名内部类的方式了
        //生成一个LinearLayoutManager的对象
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HorLinearRecyclerViewActivity.this);
        //设置这个线性布局管理器的方向,为水平方向
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        //设置mHorRV的线性布局管理器
        mhorRV.setLayoutManager(linearLayoutManager);
        //设置适配器：Adapter
        mhorRV.setAdapter(new HorLinearAdapter(HorLinearRecyclerViewActivity.this));

    }
}
