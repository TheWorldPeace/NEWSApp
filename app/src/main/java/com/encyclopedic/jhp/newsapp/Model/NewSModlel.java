package com.encyclopedic.jhp.newsapp.Model;

import android.util.Log;

import com.encyclopedic.jhp.newsapp.Bean.NewsBean;
import com.encyclopedic.jhp.newsapp.Utils.API;
import com.encyclopedic.jhp.newsapp.Utils.RetrofitHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewSModlel implements INewsModel{
    @Override
    public void loadNews(String hostType, int startPage, String id, final IOnLoadListener iOnLoadListener) {
        Log.i("loadNewIn","hostType:"+hostType+"   startPage:  "+startPage+"  id :"+id+" API.NEWS_HOST: "+API.NEWS_HOST);
        RetrofitHelper retrofitHelper=new RetrofitHelper(API.NEWS_HOST);
        retrofitHelper.getNews(hostType,id,startPage).enqueue(new Callback<NewsBean>() {
            @Override
            public void onResponse(Call<NewsBean> call, Response<NewsBean> response) {
                Log.i("TAG", String.valueOf(response.body()));
                if(response.isSuccessful()){
                    iOnLoadListener.success(response.body());
                }else{
                    iOnLoadListener.fail("");
                    Log.i("TAG","解析报错");
                }
            }

            @Override
            public void onFailure(Call<NewsBean> call, Throwable t) {
                Log.i("TAG","接口不通");
                    iOnLoadListener.fail(t.toString());
            }
        });
    }
}
