package com.vastrek.geelyhelper.test;

import android.app.ActionBar;
import android.view.View;
import android.widget.Button;

import com.lidroid.xutils.view.annotation.ViewInject;
import com.vastrek.geelyhelper.R;
import com.vastrek.geelyhelper.frame.ui.Page;
import com.vastrek.geelyhelper.middleware.M;

public class TestPage1 extends Page{


	@ViewInject(R.id.search_view)
	private Button tv;
	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return "µÚÒ»Ò³";
	}

	@Override
	protected void initActionBar(ActionBar actionBar) {
		// TODO Auto-generated method stub
	}

	@Override
	public int getLayoutId() {
		// TODO Auto-generated method stub
		return R.layout.fragment_main;
	}

	@Override
	public void onStart() {
		tv.setText("¼ªÀû");
		tv.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				M.gotoPage(getActivity(), TestPage2.class);
			}
		});
	}


	
}
