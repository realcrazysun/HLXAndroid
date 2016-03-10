package com.polyent.hlx.api;


import retrofit2.Call;
import retrofit2.http.GET;
import com.polyent.hlx.ui.bean.RootObject;

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

}
