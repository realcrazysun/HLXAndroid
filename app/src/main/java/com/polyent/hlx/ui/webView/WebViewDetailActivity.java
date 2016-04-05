package com.polyent.hlx.ui.webView;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.gson.Gson;
import com.polyent.hlx.R;
import com.polyent.hlx.adapter.chat.ContactAdapter;
import com.polyent.hlx.api.HLXAPIService;
import com.polyent.hlx.net.ServiceGenerator;
import com.polyent.hlx.ui.bean.RootObject;
import com.polyent.hlx.ui.bean.chat.ContactModel;
import com.polyent.hlx.utils.ParamsUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by crazysun on 16/3/18.
 */
public class WebViewDetailActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.webview)
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_detail_activity);
        ButterKnife.bind(this);
        initView();
        String url = getIntent().getStringExtra("url");
        loadUrl(url);
    }

    private void initView() {

        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.btn_back);
    }

    private void loadUrl(String url) {
        webview.loadUrl(url);
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
