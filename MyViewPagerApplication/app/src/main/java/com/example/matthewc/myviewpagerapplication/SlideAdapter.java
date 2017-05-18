package com.example.matthewc.myviewpagerapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by matthewc on 4/13/2017.
 */
public class SlideAdapter extends FragmentStatePagerAdapter {
    ArrayList<Fragment> pages;

    public SlideAdapter(FragmentManager fm) {
        super(fm);
        pages = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return pages.get(position);
    }

    @Override
    public int getCount() {
        return pages.size();
    }
}
