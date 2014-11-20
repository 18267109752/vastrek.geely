package com.vastrek.geelyhelper.frame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import com.vastrek.geelyhelper.R;
import com.vastrek.geelyhelper.frame.struct.ActValue;
import com.vastrek.geelyhelper.test.PlaceholderFragment;
import com.vastrek.geelyhelper.ui.Page;

/**
 * 
 * @author zhaoheng
 * 所有Activity的基类
 */
public class BaseActivity extends Activity{
	
	private ActValue mActValue;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		else{
			mActValue = (ActValue) savedInstanceState.getSerializable("actvalue");
			loadPage();
		}
	}
	
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
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	
}
