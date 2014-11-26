package com.vastrek.geelyhelper.frame.ui;


import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 
 * @author zhaoheng
 * Բ��ImageView
 */
public class RoundTextView extends TextView {

	private RoundHelper roundHelper;
	
	public RoundTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);
	}

	public RoundTextView(Context context) {
		super(context);
		init(context, null);
	}

	private void init(Context context, AttributeSet attrs) {

		roundHelper = new RoundHelper(context);
		roundHelper.getRadiusFromAttributeSet(attrs);
	}

	public void setRectAdius(float adius) {
		roundHelper.setRadius(adius);
		invalidate();
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right,
			int bottom) {
		super.onLayout(changed, left, top, right, bottom);
		int w = getWidth();
		int h = getHeight();
		roundHelper.setRect(0, 0, w, h);
	}

	@Override
	public void draw(Canvas canvas) {
		roundHelper.draw(canvas);
		super.draw(canvas);
		canvas.restore();
	}

}