package com.encyclopedic.jhp.newsapp.View;

import com.encyclopedic.jhp.newsapp.Bean.NewsBean;

public interface INewsView {
    void showNews(NewsBean newsBean);
    void hidDialog();
    void showDialog();
    void showErrorMsg(String eerrorMsg);
}
