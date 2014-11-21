package com.vastrek.geelyhelper.frame.ui;

import android.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;

import com.lidroid.xutils.ViewUtils;
import com.vastrek.geelyhelper.frame.BaseActivity;

/**
 * 
 * @author zhaoheng
 *
 */
public abstract class Page{

	protected BaseActivity mActivity;
	protected View mRootView;
	public Page(){
		
	}

	public void attachActivity(BaseActivity activity){
		mActivity = activity;
		initActionBar(activity.getActionBar());
		onCreateView(activity.getLayoutInflater());
	}
	public void setPageData(Object value){
		
	}

	protected View onCreateView(LayoutInflater inflater) {
		mRootView = inflater.inflate(getLayoutId(), null);
		ViewUtils.inject(this, mRootView);
		return mRootView;
	}
	
	public View getRootView(){
		return mRootView;
	}
	
	public BaseActivity getActivity(){
		return mActivity;
	}
	public abstract String getTitle();
	protected abstract void initActionBar(ActionBar actionBar);
	public abstract int getLayoutId();
	
	public abstract void onStart();
	public void onStop(){}
}
