package com.vastrek.geelyhelper.middleware;

import android.app.Activity;
import android.content.Intent;

import com.vastrek.geelyhelper.frame.BaseActivity;

/**
 * 
 * @author zhaoheng
 * 
 */
public class M {

	public static final <T extends BaseActivity> void gotoActivity(Activity fromActivity,Class<T> toActivity){
		gotoActivity(fromActivity, toActivity, null);
	}
	
	public static final <T extends BaseActivity> void gotoActivity(Activity fromActivity,Class<T> toActivity,boolean closeThis){
		
	}
	
	public static final <T extends BaseActivity> void gotoActivity(Activity fromActivity,Class<T> toActivity,Object value){
		Intent intent = new Intent(fromActivity, toActivity);
		fromActivity.startActivity(intent);
	}
}
