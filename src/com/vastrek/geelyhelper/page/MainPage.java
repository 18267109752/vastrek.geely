package com.vastrek.geelyhelper.page;

import com.lidroid.xutils.view.annotation.ViewInject;
import com.vastrek.geelyhelper.R;
import com.vastrek.geelyhelper.frame.ui.CustomActionBar;
import com.vastrek.geelyhelper.frame.ui.Page;
import com.vastrek.geelyhelper.ui.MainPageButton;
import com.vastrek.geelyhelper.ui.MainPageButton.ButtonStruct;

/**
 * @author zhaoheng
 *
 */
public class MainPage extends Page{

	
	@ViewInject(R.id.main1)
	MainPageButton button;
	
	@Override
	public String getTitle() {
		return null;
	}

	@Override
	protected void initActionBar(CustomActionBar actionBar) {
		actionBar.hide();
	}

	@Override
	public int getLayoutId() {
		return R.layout.page_main;
	}

	@Override
	public void onStart() {
		button.setOrientation(MainPageButton.VERTICAL);
		ButtonStruct struct = new ButtonStruct();
		struct.text = "wfsdfas";
		button.setButtonStruct(struct);
	}

}
