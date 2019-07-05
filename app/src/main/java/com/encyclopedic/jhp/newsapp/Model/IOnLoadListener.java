package com.encyclopedic.jhp.newsapp.Model;

import com.encyclopedic.jhp.newsapp.Bean.NewsBean;

public interface IOnLoadListener {
    void success(NewsBean newsBean);
    void fail(String error);

}
