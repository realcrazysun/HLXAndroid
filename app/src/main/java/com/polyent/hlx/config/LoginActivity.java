package com.polyent.hlx.config;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.polyent.hlx.R;
import com.polyent.hlx.api.HLXAPIService;
import com.polyent.hlx.net.ServiceGenerator;
import com.polyent.hlx.ui.bean.LoginUserBean;
import com.polyent.hlx.ui.bean.RootObject;
import com.polyent.hlx.ui.bean.dynamic.HomeIndexInfoModel;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by crazysun on 16/3/14.
 */
public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.login)
    ImageView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();

    }

    private void initView() {

        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.btn_back);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendLoginRequest();
            }
        });
    }

    private void sendLoginRequest() {
        HLXAPIService git = ServiceGenerator.createService(HLXAPIService.class);
        Call call = git.thirdLogin(getLoginParameters());

        call.enqueue(new Callback<RootObject>() {
            @Override
            public void onResponse(Response<RootObject> response) {

                RootObject model = response.body();
                if (model == null) {
                    AppContext.getInstance().cleanLoginInfo();
//                    AppContext.showToast(loginUserBean.getResult().getErrorMessage());
                    System.out.println("onResponse : model is null");
                } else if (!model.getRet().equals("0")) {
                    AppContext.getInstance().cleanLoginInfo();
                    System.out.println("onResponse : model is null" + model.getRet());
                } else {
                    Gson gson = new Gson();
                    LoginUserBean userBean = gson.fromJson(gson.toJson(model.getData()), LoginUserBean.class);
                    handleLoginBean(userBean);
                }
                //warning 这里经常抛出异常 应该找到原因


            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("failed");
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

    private HashMap<String, String> getLoginParameters() {

        HashMap<String, String> ret = new HashMap<>();
        ret.put("access_token", "8a7c2136f86a95e256b67e73de4c1544");
        JsonObject data = new JsonObject();
        JsonObject params = new JsonObject();
        params.addProperty("weiboType", "qq");
        params.addProperty("openId", "3D30D2BF01AD011252695BCE71B89AFC");

        data.add("params", params);
        ret.put("data", data.toString());

        ret.put("device", "E542B165-08ED-4529-AF7C-B15F8DE0B199");
        ret.put("platform", "iPhone 5");
        ret.put("network", "1");
        ret.put("screen_height", "568.000000");
        ret.put("screen_width", "320.000000");
        ret.put("system", "1");
        ret.put("system_version", "9.2");
        ret.put("version", "4.4.0");


        return ret;
    }

    // 处理loginBean
    private void handleLoginBean(LoginUserBean loginUserBean) {


        AppContext.getInstance().saveUserInfo(loginUserBean);
        finish();
    }
}
