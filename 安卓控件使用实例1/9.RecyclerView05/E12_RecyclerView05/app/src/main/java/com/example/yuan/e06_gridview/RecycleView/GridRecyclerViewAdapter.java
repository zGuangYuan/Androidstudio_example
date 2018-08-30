package com.example.yuan.e06_gridview.RecycleView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.yuan.e05_listview.R;

public class GridRecyclerViewAdapter extends RecyclerView.Adapter<GridRecyclerViewAdapter.MyViewHolder> {
    //声明引用
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    //创建一个构造函数：
    public GridRecyclerViewAdapter(Context context){
        this.mContext=context;
        //利用LayoutInflater把控件所在的布局文件加载到当前类当中
        mLayoutInflater = LayoutInflater.from(context);
    }
    @Override
    public GridRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //返回一个ViewHolder类型的数据，返回ViewHolder子类的对象，把布局文件加载到当前类返回
        return new MyViewHolder(mLayoutInflater.inflate(R.layout.layout_grid_recyclerview_item,parent,false));
    }

    @Override
    public void onBindViewHolder(GridRecyclerViewAdapter.MyViewHolder holder, final int position) {
        holder.textView.setText("跑车");
        Glide.with(mContext).load("http://image.bitautoimg.com/appimage/media/20170317/w1600_h900_f6a5cad43dda443184bc2a6d5ecf44b4.jpeg").into(holder.imageView);
        //设置监听器，短点击
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"短点击位置"+position,Toast.LENGTH_SHORT).show();
            }
        });
        //长点击
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(mContext,"长点击位置"+position,Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{
        //声明引用
        private ImageView imageView;
        private TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            //获取控件对象
            imageView=(ImageView) itemView.findViewById(R.id.IV_GridRV_Id);
            textView=(TextView) itemView.findViewById(R.id.TV_GridRV_Id);
        }
    }

}
