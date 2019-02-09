package com.example.oheunji.chungmuro;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabPagerAdapter extends FragmentPagerAdapter {
    private int tabCount;

    public TabPagerAdapter(FragmentManager fm, int tabCount){
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                MainTabFragment1 mainTabFragment1 = new MainTabFragment1();
                return mainTabFragment1;
            case 1:
                MainTabFragment2 mainTabFragment2 = new MainTabFragment2();
                return mainTabFragment2;
            case 2:
                MainTabFragment3 mainTabFragment3 = new MainTabFragment3();
                return mainTabFragment3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}