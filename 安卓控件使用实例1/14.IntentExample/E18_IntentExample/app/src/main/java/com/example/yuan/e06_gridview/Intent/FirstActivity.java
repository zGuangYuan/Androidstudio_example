package com.example.yuan.e06_gridview.Intent;

        import android.app.Activity;
        import android.content.ComponentName;
        import android.content.Intent;
        import android.support.annotation.Nullable;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.Toast;

        import com.example.yuan.e05_listview.R;

public class FirstActivity extends AppCompatActivity {
    //声明引用
    private Button mIntentButton1,mIntentButton2,mIntentButton3,mIntentButton4,mIntentButton5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        //获取控件实体
        mIntentButton1 = (Button) findViewById(R.id.Button_IntentId_1);
        mIntentButton2 = (Button) findViewById(R.id.Button_IntentId_2);
        mIntentButton3 = (Button) findViewById(R.id.Button_IntentId_3);
        mIntentButton4 = (Button) findViewById(R.id.Button_IntentId_4);
        mIntentButton5 = (Button) findViewById(R.id.Button_IntentId_5);

        //生成监听器对象listener
        IntentButtonListener listener = new IntentButtonListener();
        //设置监听器
        mIntentButton1.setOnClickListener(listener);
        mIntentButton2.setOnClickListener(listener);
        mIntentButton3.setOnClickListener(listener);
        mIntentButton4.setOnClickListener(listener);
        mIntentButton5.setOnClickListener(listener);
    }
    class IntentButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent =null;
            switch (v.getId()){
                case R.id.Button_IntentId_1:
                    //显示跳转方法一
                    intent = new Intent(FirstActivity.this,SecondActivity.class);
                    Bundle bundle =new Bundle();
                    bundle.putString("name","源哥哥");
                    bundle.putInt("age",18);
                    intent.putExtras(bundle);

                    startActivityForResult(intent,0);
                    break;
                case R.id.Button_IntentId_2:
                    //显示跳转方法二
                    intent = new Intent();
                    intent.setClass(FirstActivity.this,SecondActivity.class);
                    break;
                case R.id.Button_IntentId_3:
                    //显示跳转方法三
                    intent = new Intent();
                    intent.setClassName(FirstActivity.this,"com.example.yuan.e06_gridview.Intent.SecondActivity");
                    break;
                case R.id.Button_IntentId_4:
                    //显示跳转方法四
                    intent = new Intent();
                    intent.setComponent(new ComponentName(FirstActivity.this,"com.example.yuan.e06_gridview.Intent.SecondActivity"));
                    break;
                case R.id.Button_IntentId_5:
                    //隐式跳转方式
                    intent = new Intent();
                    intent.setAction("com.yuan.intent.SecondActivity");
                    break;

            }
            //startActivity(intent);
        }

    }
    //接受来自别的Activity返回的数据
    //requestCode就是我们传过去的：0，resultCode是从另一个Activity传过来的：Activity.RESULT_OK（静态变量：-1）
    //date 就是返回的Intent对象
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String result = data.getExtras().getString("result");
        int  intdata = data.getExtras().getInt("data");
        //直接通过弹窗的方式返回数据
        Toast.makeText(FirstActivity.this,"返回结果："+result+"，返回数据："+intdata,Toast.LENGTH_LONG).show();
    }
}
