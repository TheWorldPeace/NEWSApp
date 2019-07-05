package com.encyclopedic.jhp.newsapp.Model;

public interface INewsModel {
    void loadNews(String hostType,
                  int startPage,
                  String id,
                  IOnLoadListener iOnLoadListener);
}
