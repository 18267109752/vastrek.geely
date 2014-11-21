package com.vastrek.geelyhelper.utils;

import android.content.res.Resources;
import android.util.TypedValue;

public class Utils {

	public static int dpToPx(Resources res, int dp) {
		return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, res.getDisplayMetrics());
	}

}
