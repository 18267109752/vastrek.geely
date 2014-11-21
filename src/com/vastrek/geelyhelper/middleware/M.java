package com.vastrek.geelyhelper.middleware;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.vastrek.geelyhelper.frame.BaseActivity;
import com.vastrek.geelyhelper.frame.struct.ActValue;
import com.vastrek.geelyhelper.frame.ui.Page;

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
	
	public static final <T extends Page>void gotoPage(Activity fromActivity,Class<T> gotoPage){
		gotoPage(fromActivity, gotoPage, null);
	}
	
	public static final <T extends Page>void gotoPage(Activity fromActivity,Class<T> gotoPage,Object value){
		
		Intent intent = new Intent(fromActivity, BaseActivity.class);
		ActValue actValue = new ActValue();
		actValue.gotoPage = gotoPage;
		actValue.value = value;
		intent.putExtra("actvalue", actValue);
		fromActivity.startActivity(intent);
	}
}
