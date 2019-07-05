package com.encyclopedic.jhp.newsapp.NewsApp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.encyclopedic.jhp.newsapp.Bean.NewsBean;
import com.encyclopedic.jhp.newsapp.Presenter.NewsPresenter;
import com.encyclopedic.jhp.newsapp.R;
import com.encyclopedic.jhp.newsapp.View.INewsView;

import java.util.TimerTask;

public class NewsListFragment extends Fragment implements INewsView {
    private int type;
    private TextView tv_news;
    private NewsPresenter presenter;
    private SwipeRefreshLayout srl_news;
    public static NewsListFragment newInstance(int type){
        Bundle args=new Bundle();
        NewsListFragment newsListFragment=new NewsListFragment();
        args.putInt("type",type);
        newsListFragment.setArguments(args);
        return newsListFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fg_news_list,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        type=getArguments().getInt("type");
        tv_news=view.findViewById(R.id.tv_news);
        srl_news=view.findViewById(R.id.sl_news);
        srl_news.setColorSchemeColors(Color.parseColor("#ffce3d3a"));
        presenter=new NewsPresenter(this);
        srl_news.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loadNews(type,0);
            }
        });
//        switch (type){
//            case NewsAppFragment.NEWS_TYPE_TOP:
//                tv_news.setText("top");
//                break;
//            case NewsAppFragment.NEWS_TYPE_NBA:
//                tv_news.setText("NBA");
//                break;
//            case NewsAppFragment.NEWS_TYPE_JOKES:
//                tv_news.setText("VIDEO");
//                break;
//        }
    }

    @Override
    public void showNews(final NewsBean newsBean) {
        getActivity().runOnUiThread(new TimerTask() {
            @Override
            public void run() {
                switch (type){
                    case NewsAppFragment.NEWS_TYPE_TOP:
                        tv_news.setText(newsBean.getT1348647909107().get(0).getAlias());
                    break;
                    case NewsAppFragment.NEWS_TYPE_NBA:
                        tv_news.setText(newsBean.getT1348649145984().get(0).getAlias());
                        break;
                    case NewsAppFragment.NEWS_TYPE_JOKES:
                        tv_news.setText(newsBean.getTT1350383429665().get(0).getAlias());
                        break;
                }
            }
        });
    }

    @Override
    public void hidDialog() {
        srl_news.setRefreshing(false);
    }

    @Override
    public void showDialog() {
        srl_news.setRefreshing(true);
    }

    @Override
    public void showErrorMsg(String eerrorMsg) {
        tv_news.setText("加载失败"+eerrorMsg);
    }
}
