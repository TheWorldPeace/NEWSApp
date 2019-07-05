package com.encyclopedic.jhp.newsapp.Utils;

import com.encyclopedic.jhp.newsapp.Bean.NewsBean;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private static OkHttpClient okHttpClient;
    private RetrofitService retrofitService;
    public RetrofitHelper(String host){
        Retrofit retrofit=new Retrofit.Builder().baseUrl(host).client(getOkhttpClient()).addConverterFactory(GsonConverterFactory.create()).build();
        retrofitService =retrofit.create(RetrofitService.class);
    }

    private OkHttpClient getOkhttpClient() {
        if(okHttpClient==null){
            okHttpClient=new OkHttpClient.Builder().retryOnConnectionFailure(true).connectTimeout(300,TimeUnit.SECONDS).build();
        }
        return okHttpClient;
    }

    public Call<NewsBean> getNews(String type,String id,int startPage){
        return retrofitService.getNews(type,id,startPage);
    }
}
