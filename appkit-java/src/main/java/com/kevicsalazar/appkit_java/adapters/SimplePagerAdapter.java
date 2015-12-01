package com.kevicsalazar.appkit_java.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
public class SimplePagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;
    private List<String> titleList;

    public SimplePagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentList = new ArrayList<>();
        titleList = new ArrayList<>();
    }

    public void addFragment(Fragment fragment) {
        fragmentList.add(fragment);
        titleList.add("");
    }

    public void addFragment(Fragment fragment, String title) {
        fragmentList.add(fragment);
        titleList.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

}
