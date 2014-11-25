package com.vastrek.geelyhelper.page;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Intent;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.View;
import android.widget.Button;

import com.facebook.rebound.test.MainActivity;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.vastrek.geelyhelper.R;
import com.vastrek.geelyhelper.content.ContentGetter;
import com.vastrek.geelyhelper.frame.ui.CustomActionBar;
import com.vastrek.geelyhelper.frame.ui.Page;
import com.vastrek.geelyhelper.test.TestModel;

public class LoginPage extends Page{

	@ViewInject(R.id.login_btn)
	View view;
	
	@ViewInject(R.id.login_rotate)
	Button rotateButton;
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
		return R.layout.page_login;
	}

	@Override
	public void onStart() {
		view.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ContentGetter<TestModel> getter = new ContentGetter<>(TestModel.class, 0);
				TestModel mo = getter.getFromIdArray(mRootView, R.id.login_username,R.id.login_pwd);
				Intent intent = new Intent(mActivity, MainActivity.class);
				mActivity.startActivity(intent);
			}
		});
		
	} 

//	@OnClick(R.id.login_rotate)
//	public void rotateButton(final View view){
//		ObjectAnimator anim = ObjectAnimator.ofFloat(view, "xyz", 1.0F,0.0F).setDuration(500);
//		anim.addUpdateListener(new AnimatorUpdateListener() {
//			
//			@Override
//			public void onAnimationUpdate(ValueAnimator animation) {
//				
//				float cVal = (Float) animation.getAnimatedValue();  
//	            view.setAlpha(cVal);  
//	            view.setScaleX(cVal);  
//	            view.setScaleY(cVal);
//			}
//		});
//		anim.start();
//	}
	
//	@OnClick(R.id.login_rotate)
//	public void rotateButton(final View view){
//		PropertyValuesHolder pvh1 = PropertyValuesHolder.ofFloat("alpha", 1.0f,0.5f);
//		PropertyValuesHolder pvh2 = PropertyValuesHolder.ofFloat("scaleX", 1.0f,0.5f);
//		PropertyValuesHolder pvh3 = PropertyValuesHolder.ofFloat("scaleY", 1.0f,0.5f);
//		ObjectAnimator.ofPropertyValuesHolder(view, pvh1,pvh2,pvh3).setDuration(500).start();
//	}
	
//	@OnClick(R.id.login_rotate)
//	public void rotateButton(final View view){
//		ValueAnimator va = ValueAnimator.ofFloat(0,400);
//		va.setTarget(view);
//		va.setDuration(500);
//		va.start();
//	}
	
//	@OnClick(R.id.login_rotate)
//	public void rotateButton(final View view){
//		Animator anim = AnimatorInflater.loadAnimator(getActivity(), R.animator.scalex);
//		view.setPivotX(0);
//		view.setPivotY(0);
//		anim.setTarget(view);
//		anim.start();
//		
//	}
	
	@OnClick(R.id.login_rotate)
	public void rotateButton(final View view){
		ViewWrapper wrapper = new ViewWrapper(view);
	    ObjectAnimator.ofFloat(view, "height", 1.0f,0.5f).setDuration(1000).start();
		
	}

	private static class ViewWrapper {
	    private View mTarget;
	 
	    public ViewWrapper(View target) {
	        mTarget = target;
	    }
	 
	    public int getWidth() {
	        return mTarget.getLayoutParams().width;
	    }
	 
	    public void setWidth(int width) {
	        mTarget.getLayoutParams().width = width;
	        mTarget.requestLayout();
	    }
	    
	    public int getHeight(){
	    	return mTarget.getLayoutParams().height;
	    }
	    
	    public void setHeight(int height) {
	        mTarget.getLayoutParams().height = height;
	        mTarget.requestLayout();
	    }
	}
}
