package com.vastrek.geelyhelper.content;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewBridge {

	/**
	 * ����Ϊ��Ӧ��viewId,�Ӷ����Ի�ȡ��ֵ
	 * @return
	 */
	int[] value();
}
