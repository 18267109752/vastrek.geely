package com.vastrek.geelyhelper.test;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lidroid.xutils.view.annotation.ViewInject;
import com.vastrek.geelyhelper.R;
import com.vastrek.geelyhelper.frame.ui.CustomActionBar;
import com.vastrek.geelyhelper.frame.ui.JazzyViewPager;
import com.vastrek.geelyhelper.frame.ui.JazzyViewPager.TransitionEffect;
import com.vastrek.geelyhelper.frame.ui.Page;
import com.vastrek.geelyhelper.frame.ui.PagerSlidingTabStrip;

public class TestPage2 extends Page{


	@ViewInject(R.id.jazzy_pager)
	private JazzyViewPager mJazzy;
	@ViewInject(R.id.tabs)
	private PagerSlidingTabStrip tabStrip;
	@Override
	public String getTitle() {
		return "第二页";
	}

	@Override
	protected void initActionBar(CustomActionBar actionBar) {
	}

	@Override
	public int getLayoutId() {
		return R.layout.page_test2;
	}

	@Override
	public void onStart() {
		tabStrip.setTabLayoutParams(new LinearLayout.LayoutParams(0,-1,1));
		setupJazziness(TransitionEffect.Standard);
		tabStrip.setViewPager(mJazzy);
	}


	private void setupJazziness(TransitionEffect effect) {
		mJazzy.setTransitionEffect(effect);
		mJazzy.setAdapter(new MainAdapter(getActivity().getSupportFragmentManager()));
		mJazzy.setPageMargin(30);
	}
	
	private class MainAdapter extends FragmentPagerAdapter {

		private final String[] TITLES = { "初始", "故障", "外观", "保养"};
		public MainAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return TITLES[position];
		}
		@Override
		public Fragment getItem(int arg0) {
			return new TestFrag();
		}

		@Override
		public int getCount() {
			return TITLES.length;
		}

		@Override
		public void setPrimaryItem(ViewGroup container, int position,
				Object object) {
			// TODO Auto-generated method stub
			super.setPrimaryItem(container, position, object);
		}
		
		
	}
	
}
