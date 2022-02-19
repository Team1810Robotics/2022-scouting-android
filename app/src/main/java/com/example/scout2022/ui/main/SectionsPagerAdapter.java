package com.example.scout2022.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.scout2022.page_Basic;
import com.example.scout2022.page_Auto;
import com.example.scout2022.page_Final;
import com.example.scout2022.R;
import com.example.scout2022.page_TeleOp;


/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3, R.string.tab_text_4};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a new page.
        // video below clarifies creating and modifying tabs
        // https://www.youtube.com/watch?v=h4HwU_ENXYM
        // each case is a different page
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new page_Basic(); //Start Page
                break;
            case 1:
                fragment = new page_Auto(); //Auto page
                break;
            case 2:
                fragment = new page_TeleOp(); //TeleOp Page
                break;
            case 3:
                fragment = new page_Final(); //Final page
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 4 total pages.
        return 4;
    }
}