package com.encyclopedic.jhp.newsapp.Adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class AppNewsFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments=new ArrayList<>();
    private List<String> fragmengtTitles=new ArrayList<>();

    public AppNewsFragmentAdapter(FragmentManager fm,List<Fragment> fragments) {
        super(fm);
        this.fragments=fragments;
    }
    public AppNewsFragmentAdapter(FragmentManager fm,List<Fragment> fragments,List<String> fragmengtTitles){
        super(fm);
        this.fragments=fragments;
        this.fragmengtTitles=fragmengtTitles;

    }
    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.destroyItem(container, position, object);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(fragmengtTitles!=null){
            return fragmengtTitles.get(position);
        }else{
            return "";
        }
    }
}
