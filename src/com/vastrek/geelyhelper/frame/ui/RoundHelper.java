package com.vastrek.geelyhelper.frame.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;

import com.vastrek.geelyhelper.R;

/**
 * @author zhaoheng
 *
 */
public class RoundHelper {

	private Context context;
	private final RectF roundRect = new RectF();
	private float rect_adius = 5;
	private final Paint maskPaint = new Paint();
	private final Paint zonePaint = new Paint();
	
	public RoundHelper(Context context){
		this.context = context;
		maskPaint.setAntiAlias(true);
		maskPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
		//
		zonePaint.setAntiAlias(true);
		zonePaint.setColor(Color.WHITE);
	}
	
	public void getRadiusFromAttributeSet(AttributeSet attrs){
		if (attrs != null) {
			TypedArray a = context.obtainStyledAttributes(attrs,
					R.styleable.RoundedView);
			rect_adius = a.getDimensionPixelSize(
					R.styleable.RoundedView_rounded_radius, (int) rect_adius );
			a.recycle();
		} else {
			float density = context.getResources().getDisplayMetrics().density;
			rect_adius  = (int) (rect_adius  * density);
		}
	}
	
	public void setRadius(float radius){
		this.rect_adius = radius;
	}
	
	public void setRect(float left,float top,float right,float bottom){
		roundRect.set(left, top, right, bottom);
	}
	
	public void draw(Canvas canvas){
		canvas.saveLayer(roundRect, zonePaint, Canvas.ALL_SAVE_FLAG);
		canvas.drawRoundRect(roundRect, rect_adius, rect_adius, zonePaint);
		//
		canvas.saveLayer(roundRect, maskPaint, Canvas.ALL_SAVE_FLAG);
	}
}
