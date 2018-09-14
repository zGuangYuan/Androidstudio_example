package com.example.yuan.e06_gridview.WebView;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.example.yuan.e05_listview.R;

public class WebViewActivity extends AppCompatActivity {

    //声明引用
    private WebView mWVmhtml;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        //获取控件对象
        mWVmhtml=(WebView) findViewById(R.id.WV_Id);
        //加载本地html文件
       // mWVmhtml.loadUrl("file:///android_asset/hello.html");
        //加载网络URL
        //mWVmhtml.loadUrl("https://blog.csdn.net/qq_36243942/article/details/82187204");
        //设置JavaScrip
        mWVmhtml.getSettings().setJavaScriptEnabled(true);
        //访问百度首页
        mWVmhtml.loadUrl("https://m.baidu.com");
        //设置在当前WebView继续加载网页
        mWVmhtml.setWebViewClient(new MyWebViewClient());

        mWVmhtml.setWebChromeClient(new MyWebChromeClient());

    }
    class MyWebViewClient extends WebViewClient{
        @Override  //WebView代表是当前的WebView
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            //表示在当前的WebView继续打开网页
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.d("WebView","开始访问网页");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.d("WebView","访问网页结束");
        }
    }
    class MyWebChromeClient extends WebChromeClient{
        @Override //监听加载进度
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }
        @Override//接受网页标题
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            //把当前的Title设置到Activity的title上显示
            setTitle(title);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //如果按返回键，此时WebView网页可以后退
        if (keyCode==KeyEvent.KEYCODE_BACK&&mWVmhtml.canGoBack()){
            mWVmhtml.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
