package com.buvanesh.task.core.service;

import com.buvanesh.task.model.NewsFeedModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface NewsFeedService {
    @GET("2iodh4vg0eortkl/facts.json")
    @Headers("Content-Type: application/json")
    Call<NewsFeedModel> getNewsFeed();

}
