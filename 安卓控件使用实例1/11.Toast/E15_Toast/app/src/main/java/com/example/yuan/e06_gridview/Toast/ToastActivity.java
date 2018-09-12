package com.example.yuan.e06_gridview.Toast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yuan.e05_listview.R;
import com.example.yuan.e06_gridview.util.ToastUtil;

public class ToastActivity extends AppCompatActivity {

    //声明引用
    private Button mToast_1;
    private Button mToast_2;
    private Button mToast_3,mToast_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        //获取控件的实体
        mToast_1 =(Button) findViewById(R.id.Toast_ButtonId_1);
        mToast_2 =(Button) findViewById(R.id.Toast_ButtonId_2);
        mToast_3 =(Button) findViewById(R.id.Toast_ButtonId_3);
        mToast_4 =(Button) findViewById(R.id.Toast_ButtonId_4);
        //设置监听器
        setlistener();
    }
    private void setlistener(){
        ToastButtonListener listener = new ToastButtonListener();
        mToast_1.setOnClickListener(listener);
        mToast_2.setOnClickListener(listener);
        mToast_3.setOnClickListener(listener);
        mToast_4.setOnClickListener(listener);
    }
    class ToastButtonListener implements OnClickListener{
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.Toast_ButtonId_1:
                    Toast.makeText(ToastActivity.this,"默认Toast",Toast.LENGTH_LONG).show();
                    break;
                case R.id.Toast_ButtonId_2:
                    Toast toastCenter = Toast.makeText(ToastActivity.this,"Toast居中",Toast.LENGTH_LONG);
                    toastCenter.setGravity(Gravity.CENTER,0,0);
                    toastCenter.show();
                    break;
                case R.id.Toast_ButtonId_3:
                    //生成Toast对象
                    Toast toast = new Toast(ToastActivity.this);
                    //把布局文件引入到ToastActivity这个Activity
                    LayoutInflater inflater = LayoutInflater.from(ToastActivity.this);
                    //布局的来源
                    View view = inflater.inflate(R.layout.layout_toast,null);
                    //获取控件实体，设置ImageView和TextView控件的内容
                    ImageView imageView = (ImageView) view.findViewById(R.id.IV_ToastId);
                    TextView textView = (TextView) view.findViewById(R.id.TV_ToastId);
                    imageView.setImageResource(R.drawable.toast1);
                    textView.setText("自定义Toast");
                    //为这个Toast设置显示的内容
                    toast.setView(view);
                    //显示内容
                    toast.show();
                    break;
                case R.id.Toast_ButtonId_4:
                    ToastUtil.showMsg(getApplicationContext(),"显示最新Toast");
                    break;
            }

        }
    }


}
