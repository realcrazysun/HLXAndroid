package com.polyent.hlx.api;


import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

import com.polyent.hlx.ui.bean.RootObject;

import java.util.HashMap;

public interface HLXAPIService {

    @GET("/v1_4/site/discover")
    Call<RootObject> getDiscoverInfo();

    @GET("/v1_4/home/index")
    Call<RootObject> getHomeIndex();

    @GET("/v1_4/home/activities")
    Call<RootObject> getHomeActivities();

    @GET("/v1_4/home/get-recommend")
    Call<RootObject> getHomeRecommend();

    @GET("/v1_4/forum/juhe")
    Call<RootObject> getForumJuhe();

    @FormUrlEncoded
    @POST("/v1_4/user/followers")
    Call<RootObject> getContactorInfo(@FieldMap HashMap<String, String> object);

    //第三方登陆
    @FormUrlEncoded
    @POST("/v1_4/user/third-login")
    Call<RootObject> thirdLogin(@FieldMap HashMap<String, String> object);



}
