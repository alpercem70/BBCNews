package com.alperp.bbcnews.network;

import com.alperp.bbcnews.network.model.Channel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BBCService {

    @GET("/news/rss.xml")
    Call<Channel> getRssFeed();
}
