package com.vastrek.geelyhelper.frame.ui;

import android.app.ActionBar;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.vastrek.geelyhelper.R;

/**
 * 
 * @author zhaoheng
 *
 */
public class CustomActionBar extends LinearLayout{


	@ViewInject(R.id.actionbar_back)
	private View backBtn;
	
	@ViewInject(R.id.actionbar_logo)
	private View logoView;
	
	@ViewInject(R.id.actionbar_title)
	private TextView titleView;
	
	@ViewInject(R.id.actionbar_mid_wrapper)
	private RelativeLayout midWrapper;
	
	@ViewInject(R.id.actionbar_right_wrapper)
	private LinearLayout rightWrapper;
	
	private ActionBar mActionBar;
	public CustomActionBar(Context context, AttributeSet attrs) {
		super(context, attrs);
	}


	@Override
	protected void onFinishInflate() {
		ViewUtils.inject(this);
	}
	
	public void setTitle(String title){
		titleView.setText(title);
	}
	public void setMidCustomView(View view){
		
	}
	
	public void addRightIcon(View view){
		rightWrapper.addView(view);
	}
	
	public void addSearchIcon(){
		SearchView searchView = new SearchView(getContext());
		searchView.setLayoutParams(new LinearLayout.LayoutParams(-2,-2));
		rightWrapper.addView(searchView);
	}
	
	public void hide(){
		mActionBar.hide();
	}
	
	public void bindActionBar(ActionBar actionBar){
		mActionBar = actionBar;
	}
}
