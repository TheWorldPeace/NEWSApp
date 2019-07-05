package com.encyclopedic.jhp.newsapp.Utils;

import com.encyclopedic.jhp.newsapp.Bean.NewsBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {
    @GET("nc/article/{type}/{id}/{startPage}-20.html")
    Call<NewsBean>getNews (@Path("type")String type,
                           @Path("id")String id,
                           @Path("startPage")int startPage);
}
