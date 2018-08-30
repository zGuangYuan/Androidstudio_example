package com.example.yuan.e05_listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.yuan.e05_listview.ListView.ListViewActivity;


public class MainActivity extends AppCompatActivity {

    private Button mIVButton;
    private Button mLVButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIVButton=(Button) findViewById(R.id.IVButton_Id);
        mLVButton=(Button) findViewById(R.id.LVButton_Id);
        setlistener();
    }
    public void setlistener(){
        ButtonClickListener listener =new ButtonClickListener();
        mLVButton.setOnClickListener(listener);
        mIVButton.setOnClickListener(listener);
    }
    class ButtonClickListener implements OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.IVButton_Id:
                    intent = new Intent(MainActivity.this,ImageViewActivity.class);
                    break;
                case R.id.LVButton_Id:
                    intent =new Intent(MainActivity.this, ListViewActivity.class);
                    break;


            }
            startActivity(intent);
        }
    }
}
