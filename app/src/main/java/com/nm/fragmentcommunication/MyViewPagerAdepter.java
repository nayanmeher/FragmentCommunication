package com.nm.fragmentcommunication;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyViewPagerAdepter extends FragmentPagerAdapter {

    private Context context;
    int totalTabs;
    public MyViewPagerAdepter(FragmentManager fm, Context context, int totalTabs) {
        super(fm);
        this.context= context;
        this.totalTabs= totalTabs;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                Fragment1 fragment1= new Fragment1();
                return fragment1;
            case 1:
                Fragment2 fragment2= new Fragment2();
                return fragment2;
                default:
                    return null;
        }

    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
