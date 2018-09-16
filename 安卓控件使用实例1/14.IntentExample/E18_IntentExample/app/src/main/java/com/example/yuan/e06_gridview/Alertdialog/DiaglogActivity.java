package com.example.yuan.e06_gridview.Alertdialog;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Point;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yuan.e05_listview.R;
import com.example.yuan.e06_gridview.util.ToastUtil;
import com.example.yuan.e06_gridview.widgeDialog.CustomDialog;

public class DiaglogActivity extends AppCompatActivity {
    //声明引用
    private Button mDialogButton1,mDialogButton2,mDialogButton3,mDialogButton4,mDialogButton5,mDialogButton6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diaglog);

        //获取控件对象
        mDialogButton1 = (Button)findViewById(R.id.DG_Button_Id1);
        mDialogButton2 = (Button) findViewById(R.id.DG_Button_Id2);
        mDialogButton3 = (Button) findViewById(R.id.DG_Button_Id3);
        mDialogButton4 = (Button) findViewById(R.id.DG_Button_Id4);
        mDialogButton5 = (Button) findViewById(R.id.DG_Button_Id5);
        mDialogButton6= (Button) findViewById(R.id.DG_Button_Id6);
        //生成监听器对象，绑定监听器
        DiaglogClickListener listener = new DiaglogClickListener();
        mDialogButton1.setOnClickListener(listener);
        mDialogButton2.setOnClickListener(listener);
        mDialogButton3.setOnClickListener(listener);
        mDialogButton4.setOnClickListener(listener);
        mDialogButton5.setOnClickListener(listener);
        mDialogButton6.setOnClickListener(listener);
    }
    //设置按键的监听器类
    class DiaglogClickListener implements OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.DG_Button_Id1:
                    //采用AlertDialog的设计者模式
                    AlertDialog.Builder bulider = new AlertDialog.Builder(DiaglogActivity.this);
                    //设置标题
                    bulider.setTitle("请回答问题");
                    //设置提示信息
                    bulider.setMessage("你觉得今天天气怎么样？");
                    //设置图标
                    bulider.setIcon(R.drawable.toast1);
                    //设置属性
                    bulider.setPositiveButton("很好", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(),"天气很好",Toast.LENGTH_LONG).show();
                        }
                    })
                            .setNeutralButton("一般", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(getApplicationContext(),"天气一般",Toast.LENGTH_LONG).show();
                                }
                            }).setNegativeButton("糟糕", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(),"天气糟糕",Toast.LENGTH_LONG).show();
                        }
                    }).show();
                    break;
                case R.id.DG_Button_Id2:
                    final String [] array = new String[]{"男","女"};
                    AlertDialog.Builder bulier1 = new AlertDialog.Builder(DiaglogActivity.this);
                    bulier1.setTitle("选择你的性别").setItems(array, new DialogInterface.OnClickListener() {
                        @Override
                        //witch是数组的索引，从0开始
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(),array[which],Toast.LENGTH_LONG).show();
                        }
                    }).show();

                    break;
                case R.id.DG_Button_Id3:
                    final String [] array3 = new String[]{"男","女"};
                    AlertDialog.Builder bulier3 = new AlertDialog.Builder(DiaglogActivity.this);
                    bulier3.setTitle("选择你的性别");
                    bulier3.setSingleChoiceItems(array3, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(),array3[which],Toast.LENGTH_LONG).show();
                            //对话框消失
                            dialog.dismiss();
                        }
                    }).setCancelable(false).show();

                    break;
                case R.id.DG_Button_Id4:
                    final String [] array4 = new String[]{"唱歌","跳舞","下棋","打球"};
                    boolean [] isSelected = new boolean[]{true,false,false,false};
                    AlertDialog.Builder bulier4 = new AlertDialog.Builder(DiaglogActivity.this);
                    bulier4.setTitle("选择你的兴趣").setMultiChoiceItems(array4, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            ToastUtil.showMsg(DiaglogActivity.this,array4[which]+":"+isChecked);
                        }
                    }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(),"选择确定",Toast.LENGTH_LONG).show();
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(),"选择取消",Toast.LENGTH_LONG).show();
                        }
                    }).show();
                    break;
                case R.id.DG_Button_Id5:
                    AlertDialog.Builder bulier5 = new AlertDialog.Builder(DiaglogActivity.this);
                    //引入布局文件到当前的Activity,返回一个View对象
                    View view = LayoutInflater .from(DiaglogActivity.this).inflate(R.layout.layout_dialog,null);
                    //声明控件，获取控件对象
                    EditText UserNmae =(EditText) view.findViewById(R.id.usernameId);
                    EditText Passward = (EditText) view.findViewById(R.id.passwardId);
                    Button sureButton = (Button)findViewById(R.id.Button_LoginId);
                    bulier5.setTitle("请登陆").setView(view).show();
                    break;
                case R.id.DG_Button_Id6:
                    //实例化一个CustomDialog
                    CustomDialog customDialog = new CustomDialog(DiaglogActivity.this);
                    customDialog.setTitle("温馨提示").setMessage("是否删除数据")
                            .setCancel("取消", new CustomDialog.IOnCancelListener() {
                                @Override
                                public void onCancel(CustomDialog dialog) {
                                    ToastUtil.showMsg(getApplicationContext(),"取消");
                                }
                            }).setConfirm("确定", new CustomDialog.IOnConfirmListener() {
                        @Override
                        public void onConfirm(CustomDialog dialog) {
                            ToastUtil.showMsg(getApplicationContext(),"确认");
                        }
                    }).show();
                    break;
            }

        }

    }
}
