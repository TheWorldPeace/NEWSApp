package com.encyclopedic.jhp.newsapp.NewsApp;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.encyclopedic.jhp.newsapp.Adapter.AppNewsFragmentAdapter;
import com.encyclopedic.jhp.newsapp.R;

import java.util.ArrayList;

/**
 *
 * 20190626
 * 用于fragment和okhttp构造类似hupu的新闻app
 * 参考链接 ：https://www.jianshu.com/p/9334b13350af
 * use ViewPager,TabLayout,FragmentPagerAdapter,Fragment
 */
public class NewsAppActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private View view_status;
    private ImageView iv_title_news;
    private ImageView iv_title_pic;
    private ImageView iv_title_vid;
    private ViewPager vp_contennt;
    private Toolbar toolbar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ativity_main_newsapp);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            getWindow().setStatusBarColor(Color.parseColor("#ffce3d3a"));
        }
        initView();
        initContentFragment();
    }

    private void initView() {
        view_status=(View)findViewById(R.id.view_status);
        iv_title_news=(ImageView)findViewById(R.id.iv_title_news);
        iv_title_pic=(ImageView)findViewById(R.id.iv_title_picture);
        iv_title_vid=(ImageView)findViewById(R.id.iv_title_video);
        vp_contennt=(ViewPager)findViewById(R.id.vp_content_newsapp);
        toolbar=(Toolbar)findViewById(R.id.newsapp_toolbars);
        iv_title_vid.setOnClickListener(this);
        iv_title_pic.setOnClickListener(this);
        iv_title_news.setOnClickListener(this);
    }
    private  void initContentFragment(){
        ArrayList<Fragment> fragmentArrayList=new ArrayList<>();
        fragmentArrayList.add(new NewsAppFragment());
        fragmentArrayList.add(new PicAppFragment());
        fragmentArrayList.add(new VideAppFragment());
        AppNewsFragmentAdapter adapter=new AppNewsFragmentAdapter(getSupportFragmentManager(),fragmentArrayList);
        vp_contennt.setAdapter(adapter);
        vp_contennt.setOffscreenPageLimit(2);
        vp_contennt.addOnPageChangeListener(this);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayShowTitleEnabled(false);
        }
        //初始化
        setCurrentItem(0);
    }

    private void setCurrentItem(int i) {
        vp_contennt.setCurrentItem(i);
        iv_title_news.setSelected(false);
        iv_title_pic.setSelected(false);
        iv_title_vid.setSelected(false);
        switch (i){
            case 0:
                iv_title_news.setSelected(true);
                break;
            case 1:
                iv_title_pic.setSelected(true);
                break;
            case 2:
                iv_title_vid.setSelected(true);
                break;
        }
    }

    @Override
    public void onClick(View v) {
    switch (v.getId()){
        case R.id.iv_title_news:
            if(vp_contennt.getCurrentItem()!=0){
                setCurrentItem(0);
            }
            break;
        case R.id.iv_title_picture:
            if(vp_contennt.getCurrentItem()!=1){
                setCurrentItem(1);
            }
            break;
        case R.id.iv_title_video:
            if(vp_contennt.getCurrentItem()!=2){
                setCurrentItem(2);
            }
            break;
    }
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
