package com.vastrek.geelyhelper.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.vastrek.geelyhelper.R;
import com.vastrek.geelyhelper.frame.ui.RoundFrameLayout;

/**
 * @author zhaoheng
 * Ö÷Ò³°´Å¥
 */
public class MainPageButton extends RoundFrameLayout{

	public static final int VERTICAL 	= 1;
	public static final int HORIZONTAL 	= 2;
	
	
	private ButtonStruct buttonStruct;
	
	@ViewInject(R.id.btn_icon)
	private ImageView imageView;
	@ViewInject(R.id.btn_text)
	private TextView textView;
	@ViewInject(R.id.btn_eng)
	private TextView engView;
	
	private View rootView;
	private int orientation;
	private boolean hasSetOr = false;
	public MainPageButton(Context context) {
		super(context);
	}
	
	public MainPageButton(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public void setOrientation(int orientation){
		this.orientation = orientation;
		if(orientation == VERTICAL){
			rootView = inflate(getContext(), R.layout.layout_main_btn_v, null);
		}
		else{
			rootView = inflate(getContext(), R.layout.layout_main_btn_h, null);
		}
		ViewUtils.inject(this, rootView);
		this.addView(rootView);
		hasSetOr = true;
	}
	
	public void setButtonStruct(ButtonStruct struct){
		if(!hasSetOr){
			try {
				throw new Exception("should set orientation first!");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.buttonStruct = struct;
		imageView.setImageResource(struct.resId);
		textView.setText(struct.text);
		engView.setText(struct.eng);
	}
	
	public final static class ButtonStruct{
		public int resId;
		public String text;
		public String eng;
	}
}
