package com.polyent.hlx.ui.chat;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.polyent.hlx.R;
import com.polyent.hlx.adapter.chat.ContactAdapter;
import com.polyent.hlx.api.HLXAPIService;
import com.polyent.hlx.config.AppContext;
import com.polyent.hlx.net.ServiceGenerator;
import com.polyent.hlx.ui.bean.LoginUserBean;
import com.polyent.hlx.ui.bean.RootObject;
import com.polyent.hlx.ui.bean.chat.ContactModel;
import com.polyent.hlx.ui.bean.community.CommunityModel;
import com.polyent.hlx.ui.chat.widget.CustomEditText;
import com.polyent.hlx.ui.chat.widget.SideBar;
import com.polyent.hlx.utils.ParamsUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by crazysun on 16/3/14.
 */
public class ContactActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.school_friend_member_search_input)
    CustomEditText schoolFriendMemberSearchInput;
    @Bind(R.id.school_friend_member)
    ListView schoolFriendMember;
    @Bind(R.id.school_friend_dialog)
    TextView schoolFriendDialog;
    @Bind(R.id.school_friend_sidrbar)
    SideBar schoolFriendSidrbar;

    private ContactAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {

        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        toolbar.setTitle("我的联系人");
        toolbar.setNavigationIcon(R.mipmap.btn_back);
    }

    private void initData() {
        HLXAPIService git = ServiceGenerator.createService(HLXAPIService.class);
        Call call = git.getContactorInfo(ParamsUtil.defaultParams());
        final ContactActivity context = this;
        call.enqueue(new Callback<RootObject>() {
            @Override
            public void onResponse(Response<RootObject> response) {

                RootObject model = response.body();
                if (model == null) {
                    System.out.println("onResponse : model is null");
                } else if (!model.getRet().equals("0")) {
                    System.out.println("onResponse : model is null" + model.getRet());
                } else {
                    mAdapter = new ContactAdapter(context);
                    Gson gson = new Gson();
                    ContactModel contactModel = gson.fromJson(gson.toJson(model.getData()), ContactModel.class);
                    mAdapter.setModel(contactModel);
                    schoolFriendMember.setAdapter(mAdapter);
                }
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
}
