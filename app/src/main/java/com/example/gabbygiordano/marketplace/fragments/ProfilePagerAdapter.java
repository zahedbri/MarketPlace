package com.example.gabbygiordano.marketplace.fragments;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

/**
 * Created by gabbygiordano on 7/27/17.
 */

public class ProfilePagerAdapter extends FragmentPagerAdapter {

    private String[] tabTitles = {"Selling", "Favorited", "Interested"};
    Context context;

    SparseArray<Fragment> registeredFragments = new SparseArray<Fragment>();

    public ProfilePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    // return the total number of fragments
    @Override
    public int getCount() {
        return 3;
    }

    // return fragment to use depending on position
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ProfileTimelineFragment();
        } else if (position == 1) {
            return new FavoritesFragment();
        } else if (position == 2){
            return new InterestedFragment();
        } else {
            return null;
        }
    }

    // return page title
    @Override
    public CharSequence getPageTitle(int position) {
        // generate title based on position
        return tabTitles[position];
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment = (Fragment) super.instantiateItem(container, position);
        registeredFragments.put(position, fragment);
        return fragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        registeredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    public Fragment getRegisteredFragment(int position) {
        return registeredFragments.get(position);
    }

    public Fragment getRegisteredFragment(String title) {
        int position = -1;
        for (int i = 0; i < tabTitles.length; i++) {
            if (tabTitles[i].equals(title)){
                position = i;
                break;
            }
        }
        return registeredFragments.get(position);
    }

    public Fragment getHomeFragment() {
        return registeredFragments.get(0);
    }
}
