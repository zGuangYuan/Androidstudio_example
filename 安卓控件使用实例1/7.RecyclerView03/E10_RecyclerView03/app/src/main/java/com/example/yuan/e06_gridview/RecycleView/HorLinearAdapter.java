package com.example.yuan.e06_gridview.RecycleView;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yuan.e05_listview.R;

public class HorLinearAdapter extends RecyclerView.Adapter <HorLinearAdapter.LinearViewHolder>{
    //声明引用
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    //创建一个构造函数
    public HorLinearAdapter(Context context){
        this.mContext=context;
        //利用LayoutInflater把控件所在的布局文件加载到当前类当中
        mLayoutInflater = LayoutInflater.from(context);
    }
    //此方法要返回一个ViewHolder
    @Override
    public HorLinearAdapter.LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LinearViewHolder(mLayoutInflater.inflate(R.layout.layout_horlinearrv_item,parent,false));
    }
    //通过holder设置TextView的内容
    @Override
    public void onBindViewHolder(HorLinearAdapter.LinearViewHolder holder, final int position) {
        holder.textView.setText("模特");
        Glide.with(mContext).load("http://img.zcool.cn/community/01c8b4557aca590000002d5c60d85e.jpg@1280w_1l_2o_100sh.jpg").into(holder.imageView);

    }
    @Override
    public int getItemCount() {
        return 10;
    }
    class LinearViewHolder extends RecyclerView.ViewHolder{
        //声明layout_linearrv_item布局控件的变量
        private TextView textView;
       private ImageView imageView;

        public LinearViewHolder(View itemView) {
            super(itemView);
            textView =(TextView) itemView.findViewById(R.id.TV_RVhorLinear_title_Id);
            imageView=(ImageView) itemView.findViewById(R.id.IVhorLinear_picture_Id);
        }
    }

}
