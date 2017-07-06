package edu.gsu.httpscs.finalproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.util.Pair;

import java.util.ArrayList;

/**
 * Created by Tong on 2017/6/19.
 */

public class ViewFragmentStateAdapter extends FragmentStatePagerAdapter {
    private final ArrayList<Pair<String, Fragment>> list;

    public ViewFragmentStateAdapter(FragmentManager fm, ArrayList<Pair<String ,Fragment>> list) {
        super(fm);
        this.list = list;
    }
    @Override
    public Fragment getItem(int position) {
        return list.get(position).second;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).first;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
