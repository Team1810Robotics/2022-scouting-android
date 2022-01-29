package com.example.scout2022.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.scout2022.Page1;
import com.example.scout2022.Page2;
import com.example.scout2022.Page3;
import com.example.scout2022.Page4;
import com.example.scout2022.R;
import com.example.scout2022.databinding.FragmentPage1Binding;

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
                fragment = new Page1(); //Start Page
                break;
            case 1:
                fragment = new Page2(); //Auto page
                break;
            case 2:
                fragment = new Page3(); //TeleOp Page
                break;
            case 3:
                fragment = new Page4(); //Final page
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