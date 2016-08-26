package com.alperp.bbcnews.network;

import com.alperp.bbcnews.network.model.Rss;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BBCService {

    @GET("/news/rss.xml")
    Call<Rss> getRssFeed();
}
