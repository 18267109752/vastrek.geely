package com.vastrek.geelyhelper.page;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.vastrek.geelyhelper.R;
import com.vastrek.geelyhelper.test.TestFragmentAdapter;
import com.viewpagerindicator.LinePageIndicator;
import com.viewpagerindicator.PageIndicator;

public class WelcomePage extends FragmentActivity {
    private TestFragmentAdapter mAdapter;
    private ViewPager mPager;
    private PageIndicator mIndicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.themed_lines);

        mAdapter = new TestFragmentAdapter(getSupportFragmentManager());

        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        mIndicator = (LinePageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
    }
}