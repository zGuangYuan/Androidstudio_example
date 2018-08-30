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

public class LinearAdapter extends RecyclerView.Adapter <LinearAdapter.LinearViewHolder>{
    //声明引用
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private OnItemClickListener mlistener;
    //创建一个构造函数
    public LinearAdapter(Context context,OnItemClickListener listener){
        this.mContext=context;
        //利用LayoutInflater把控件所在的布局文件加载到当前类当中
        mLayoutInflater = LayoutInflater.from(context);
        //从外部传进来一个OnItemClickListener子类的变量
        this.mlistener=listener;
    }
    //此方法要返回一个ViewHolder
    @Override
    public LinearAdapter.LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new LinearViewHolder(mLayoutInflater.inflate(R.layout.layout_linearrv_item,parent,false));
    }
    //通过holder设置TextView的内容
    @Override
    public void onBindViewHolder(LinearAdapter.LinearViewHolder holder, final int position) {
        holder.textView.setText("模特");
        Glide.with(mContext).load("http://img.zcool.cn/community/01c8b4557aca590000002d5c60d85e.jpg@1280w_1l_2o_100sh.jpg").into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlistener.OnClick(position);
                //点击后弹窗，显示点击位置
                //Toast.makeText(mContext,"点击位置"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return 25;
    }
    class LinearViewHolder extends RecyclerView.ViewHolder{
        //声明layout_linearrv_item布局控件的变量
        private TextView textView;
       private ImageView imageView;

        public LinearViewHolder(View itemView) {
            super(itemView);
            textView =(TextView) itemView.findViewById(R.id.TV_RVLinear_title_Id);
            imageView=(ImageView) itemView.findViewById(R.id.IVLinear_picture_Id);
        }
    }
    //定义一个接口
    public interface OnItemClickListener{
        //接口默认都是抽象的方法，且类型都是public
        void OnClick(int position);
    }
}
