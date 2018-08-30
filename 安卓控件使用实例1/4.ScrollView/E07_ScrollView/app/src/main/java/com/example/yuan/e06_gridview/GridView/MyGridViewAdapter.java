package com.example.yuan.e06_gridview.GridView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yuan.e05_listview.R;

public class MyGridViewAdapter extends BaseAdapter {
    //声明引用
    private Context mContext;   //这个Context类型的变量用于第三方图片加载时用到
    private LayoutInflater mlayoutInflater;
    //创建一个构造函数
    public MyGridViewAdapter(Context context){
        this.mContext=context;
        //利用LayoutInflate把控件所在的布局文件加载到当前类中
        mlayoutInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return 10; //GridView的数目总共10个
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //写一个静态的class,把layout_grid_item的控件转移过来使用
    static class ViewHolder{
        public ImageView Grid_imageview;
        public TextView Grid_textview;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            //填写ListView的图标和标题等控件的来源，来自于layout_list_item这个布局文件
            //把控件所在的布局文件加载到当前类中
            convertView = mlayoutInflater.inflate(R.layout.layout_grid_item,null);
            //生成一个ViewHolder的对象
            holder = new ViewHolder();
            //获取控件对象
            holder.Grid_imageview=convertView.findViewById(R.id.grid_IV_Id);
            holder.Grid_textview=convertView.findViewById(R.id.grid_TV_Id);
            convertView.setTag(holder);

        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        //修改空间属性
        holder.Grid_textview.setText("汽车");
        //加载第三方网络图片
        Glide.with(mContext).load("http://pic.yesky.com/uploadImages/2013/203/37F142RUD672.jpg").into(holder.Grid_imageview);
        return convertView;
    }
}
