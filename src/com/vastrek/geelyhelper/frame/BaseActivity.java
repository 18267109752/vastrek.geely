package com.vastrek.geelyhelper.frame;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;

import com.vastrek.geelyhelper.R;
import com.vastrek.geelyhelper.frame.struct.ActValue;
import com.vastrek.geelyhelper.frame.ui.Page;
import com.vastrek.geelyhelper.page.LoginPage;
import com.vastrek.geelyhelper.test.TestPage1;

/**
 * 
 * @author zhaoheng
 * 所有Activity的基类
 */
public class BaseActivity extends FragmentActivity{
	
	private ActValue mActValue;
	private ActionBar mActionBar;
	private Page mPage;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.root_layout);
		mActionBar = getActionBar();
		Intent intent = getIntent();
		if(intent == null || intent.getSerializableExtra("actvalue") == null){
			mActValue = new ActValue();
			mActValue.gotoPage = LoginPage.class;
		}
		else{
			mActValue = (ActValue) intent.getSerializableExtra("actvalue");
		}

		loadPage(); 
		initActionBar();
	}
	
	public void hideActionBar(){
		
	}
	
	
	private void initActionBar(){
		mActionBar.setDisplayShowTitleEnabled(true);
		mActionBar.setTitle(mPage.getTitle());

	}
	/**
	 * 
	 */
	private void loadPage(){
		Class<? extends Page> pageClass = mActValue.gotoPage;
		Page page = null;
		try {
			page = pageClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		if(page == null){
			//TODO
			return ;
		}
		page.setPageData(mActValue.value);
		page.attachActivity(this);
		setContentView(page.getRootView());
		
		mPage = page;

	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onAttachedToWindow() {
		super.onAttachedToWindow();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onDetachedFromWindow() {
		super.onDetachedFromWindow();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onStart() {
		super.onStart();
		mPage.onStart();
	}

	@Override
	protected void onStop() {
		super.onStop();
		mPage.onStop();
	}

	
}
