package com.encyclopedic.jhp.newsapp.Presenter;

import com.encyclopedic.jhp.newsapp.Bean.NewsBean;
import com.encyclopedic.jhp.newsapp.Model.INewsModel;
import com.encyclopedic.jhp.newsapp.Model.IOnLoadListener;
import com.encyclopedic.jhp.newsapp.Model.NewSModlel;
import com.encyclopedic.jhp.newsapp.Utils.API;
import com.encyclopedic.jhp.newsapp.View.INewsView;
import com.encyclopedic.jhp.newsapp.NewsApp.NewsAppFragment;

public class NewsPresenter  implements INewsPresenter,IOnLoadListener {
    private INewsModel iNewsModel;
    private INewsView iNewsView;
    public NewsPresenter(INewsView iNewsView) {
        this.iNewsView=iNewsView;
        this.iNewsModel=new NewSModlel();
    }

    @Override
    public void success(NewsBean newsBean) {
        iNewsView.hidDialog();
        if(newsBean!=null){
            iNewsView.showNews(newsBean);
        }
    }

    @Override
    public void fail(String error) {
        iNewsView.hidDialog();
        iNewsView.showErrorMsg(error);
    }

    @Override
    public void loadNews(int type, int startPage) {
    iNewsView.showDialog();
    switch (type){
        case NewsAppFragment.NEWS_TYPE_TOP:
            iNewsModel.loadNews("headline",startPage,API.HEADLINE_ID,this);
            break;
        case NewsAppFragment.NEWS_TYPE_NBA:
            iNewsModel.loadNews("list",startPage,API.NBA_ID,this);
            break;
        case NewsAppFragment.NEWS_TYPE_JOKES:
            iNewsModel.loadNews("list",startPage,API.JOKE_ID,this);
            break;
    }
    }
}
