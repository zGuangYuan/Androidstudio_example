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

public class LinearAdapter extends RecyclerView.Adapter <RecyclerView.ViewHolder>{
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
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType ==0){
            return new LinearViewHolder(mLayoutInflater.inflate(R.layout.layout_linearrv_item,parent,false));
        }else{
            return new LinearViewHolder1(mLayoutInflater.inflate(R.layout.layout_linearrv_item2,parent,false));
        }

    }
    //通过holder设置TextView的内容
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
       if (getItemViewType(position) ==0){
           ((LinearViewHolder)holder).textView.setText("Hello Yuan");
           Glide.with(mContext).load("http://img.daimg.com/uploads/allimg/140729/3-140H9215513.jpg").into(((LinearViewHolder) holder).imageView);
       }else{
           Glide.with(mContext).load("http://img.article.pchome.net/01/57/12/92/pic_lib/wm/Jaguar-XFR-S-2014-widescreen-15.jpg").into(((LinearViewHolder1) holder).imageView);
       }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mlistener.OnClick(position);
                //点击后弹窗，显示点击位置
                //Toast.makeText(mContext,"点击位置"+position,Toast.LENGTH_SHORT).show();
            }
        });

    }

    //获取位置
    @Override
    public int getItemViewType(int position) {
        if(position % 2==0){  //位置是偶数
            return 0;
        }else { //位置是奇数
            return 1;
        }
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
            textView =(TextView) itemView.findViewById(R.id.TV_RVLinear_title1_Id);
            imageView=(ImageView) itemView.findViewById(R.id.IV_Linear_picture1_Id);
        }

    }
    class LinearViewHolder1 extends RecyclerView.ViewHolder{
        //声明layout_linearrv_item布局控件的变量
        private ImageView imageView;

        public LinearViewHolder1(View itemView) {
            super(itemView);
            imageView=(ImageView) itemView.findViewById(R.id.IVLinear_picture_Id2);

        }
    }
    //定义一个接口
    public interface OnItemClickListener{
        //接口默认都是抽象的方法，且类型都是public
        void OnClick(int position);
    }
}
