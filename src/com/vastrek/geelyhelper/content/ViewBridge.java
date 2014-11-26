package com.vastrek.geelyhelper.content;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewBridge {

	/**
	 * 这里为对应的viewId,从而可以获取到值
	 * @return
	 */
	int[] value();
}
