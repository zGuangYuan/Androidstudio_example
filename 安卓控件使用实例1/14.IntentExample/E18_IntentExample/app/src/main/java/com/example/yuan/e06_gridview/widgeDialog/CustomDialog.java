package com.example.yuan.e06_gridview.widgeDialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.yuan.e05_listview.R;

public class CustomDialog extends Dialog implements View.OnClickListener{
    //声明应用
    private TextView mTextViewTitle,mTextViewMsg,mTextViewCancle,mTextViewConfirm;
    private String title,message,confirm, cancel;
   //声明接口
    private IOnConfirmListener confirmListener;
    private IOnCancelListener cancelListener;
    public CustomDialog(@NonNull Context context) {
        super(context);
    }
    public CustomDialog(@NonNull Context context,int themeId) {
        super(context);
    }
    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }
    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }
    public CustomDialog setConfirm(String confirm,IOnConfirmListener listener) {
        this.confirm = confirm;
        this.confirmListener = listener;
        return this;
    }
    public CustomDialog setCancel(String cancel,IOnCancelListener listener) {
        this.cancel = cancel;
        this.cancelListener = listener;
        return this;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置Dialog的布局
        setContentView(R.layout.layout_custom_dialog);
        //设置Dialog的宽度
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        Point size = new Point();
        d.getSize(size);
        p.width = (int) (size.x * 0.8); //设置Dialog的宽度为当前手机屏幕的宽度的80%
        getWindow().setAttributes(p);
        //获取控件实体
        mTextViewTitle=(TextView) findViewById(R.id.TextView_titleId);
        mTextViewMsg=(TextView) findViewById(R.id.TextView_MessageId);
        mTextViewConfirm=(TextView) findViewById(R.id.TextView_ComfirmId);
        mTextViewCancle=(TextView) findViewById(R.id.TextView_CancleId);
        //判断文本框是否为空
        if(!TextUtils.isEmpty(title)){
            mTextViewTitle.setText(title);
        }
        if(!TextUtils.isEmpty(message)){
            mTextViewMsg.setText(message);
        }
        if(!TextUtils.isEmpty(cancel)){
            mTextViewCancle.setText(cancel);
        }
        if(!TextUtils.isEmpty(confirm)){
            mTextViewConfirm.setText(confirm);
        }
        //设置监听器,传进去一个参数是当前的Dialog
        mTextViewConfirm.setOnClickListener(this);
        mTextViewCancle.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.TextView_ComfirmId:
                if (confirmListener != null){
                    confirmListener.onConfirm(this);
                }
                dismiss(); //Dialog消失
                break;
            case R.id.TextView_CancleId:
                if (cancelListener != null){
                    cancelListener.onCancel(this);
                }
                dismiss();//Dialog消失
                break;
        }
    }
    //定义点击事件的外部回调函数
    //确定按钮的回调函数
    public interface IOnConfirmListener{
        void onConfirm(CustomDialog dialog);
    }
    //取消按钮的监听器回调函数
    public interface IOnCancelListener{
        void onCancel(CustomDialog dialog);
    }
}
