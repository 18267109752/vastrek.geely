package com.vastrek.geelyhelper.frame.ui;


import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * 
 * @author zhaoheng
 * Ô²½ÇImageView
 */
public class RoundImageView extends ImageView {

	private RoundHelper roundHelper;
	
	public RoundImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);
	}

	public RoundImageView(Context context) {
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