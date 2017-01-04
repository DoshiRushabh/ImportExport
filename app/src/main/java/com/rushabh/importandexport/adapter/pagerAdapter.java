package com.rushabh.importandexport.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rushabh.importandexport.fragments.HvdDetailsFragment;
import com.rushabh.importandexport.fragments.SpecialThanksFragment;
import com.rushabh.importandexport.fragments.companyDetailsFragment;

/**
 * Created by Rushabh on 12/21/2016.
 */

public class pagerAdapter extends FragmentPagerAdapter {


    public pagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new companyDetailsFragment();
            case 1:
                return new HvdDetailsFragment();
            case 2:
                return new SpecialThanksFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "App developer";
            case 1:
                return "Our partner";
            case 2:
                return "Special Thanks";
            default:
                return null;
        }
    }

}
