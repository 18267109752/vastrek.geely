package com.vastrek.geelyhelper.content;

/**
 * 
 * @author zhaoheng
 * 对于自定义的控件需要实现获取值的方法
 * @param <T> 设置值的类型
 */
public interface ICustomHandleValue<T> {
	Object getCustomValue();
	void setCustomValue(T value);
}
