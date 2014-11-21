package com.vastrek.geelyhelper.page;

import android.app.ActionBar;
import android.view.View;

import com.lidroid.xutils.view.annotation.ViewInject;
import com.vastrek.geelyhelper.R;
import com.vastrek.geelyhelper.frame.ui.Page;
import com.vastrek.geelyhelper.middleware.M;
import com.vastrek.geelyhelper.test.TestPage1;

public class LoginPage extends Page{

	@ViewInject(R.id.search_view)
	View view;
	@Override
	public String getTitle() {
		return null;
	}

	@Override
	protected void initActionBar(ActionBar actionBar) {
		actionBar.hide();
	}

	@Override
	public int getLayoutId() {
		return R.layout.fragment_main;
	}

	@Override
	public void onStart() {
		view.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				M.gotoPage(mActivity, TestPage1.class);
			}
		});
	}

}
