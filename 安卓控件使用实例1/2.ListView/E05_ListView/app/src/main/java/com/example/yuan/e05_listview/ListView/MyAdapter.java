package com.example.yuan.e05_listview.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yuan.e05_listview.R;

public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    //MyAdapter的构造函数，一个Context类型的参数，也就是哪一个Activity
    //这里传进去的是 ListViewActivity,ListView所在的Activity
    public MyAdapter(Context context){
        this.mContext=context;
        mLayoutInflater =LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    //写一个静态的class,把layout_list_item的控件转移过来使用
    static class ViewHolder{
        //声明引用
        public ImageView imageView;
        public TextView tvTitle,tvTime,tvContext;
    }
    //重要的方法
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //实例化ViewHolder
        ViewHolder holder = null;
        //如果视图为空
        if (convertView == null){
            //此处需要导入包，填写ListView的图标和标题等控件的来源，来自于layout_list_item这个布局文件
            convertView = mLayoutInflater.inflate(R.layout.layout_list_item,null);
            //生成一个ViewHolder的对象
            holder = new ViewHolder();
            //把layout_list_item对象转移过来，以便修改和赋值
            holder.imageView = (ImageView) convertView.findViewById(R.id.IV_list_Id);
            holder.tvTitle= (TextView) convertView.findViewById(R.id.TV_listTitle_Id);
            holder.tvTime = (TextView) convertView.findViewById(R.id.TV_listTime_Id);
            holder.tvContext= (TextView) convertView.findViewById(R.id.TV_listContext_Id);
            //把这个holder传递进去
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        //给控件赋值
        holder.tvTitle.setText("这是标题！");
        holder.tvTime.setText("2099-09-09！");
        holder.tvContext.setText("显示内容！");
        Glide.with(mContext).load("http://pic18.nipic.com/20120203/2457331_104836021342_2.jpg").into(holder.imageView);
        return convertView;
    }
}
