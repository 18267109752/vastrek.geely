package com.vastrek.geelyhelper.content;

/**
 * 
 * @author zhaoheng
 * �����Զ���Ŀؼ���Ҫʵ�ֻ�ȡֵ�ķ���
 * @param <T> ����ֵ������
 */
public interface ICustomHandleValue<T> {
	Object getCustomValue();
	void setCustomValue(T value);
}
