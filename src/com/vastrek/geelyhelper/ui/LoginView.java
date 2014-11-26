package com.vastrek.geelyhelper.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * @author zhaoheng
 *
 */
public class LoginView extends RelativeLayout{

	private ImageView headerView;
	private EditText username;
	private EditText password;
	private View btnView;
	public LoginView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

}
