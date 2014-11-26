package com.vastrek.geelyhelper.content;

import java.lang.reflect.Field;

import com.vastrek.geelyhelper.content.ruler.IContentRuler;

import android.view.View;
import android.widget.EditText;


/**
 * 
 * @author zhaoheng
 * �����Ӳ��ֻ��߶��Viewֱ������һ�������ҷ���
 * @param <T> ���ݷ��صķ���
 */
public class ContentGetter<T> extends ContentHandler{ 

	private Class<T> clazz;
	private Field[] fields;
	private int viewIndex;

	/**
	 * ���췽��
	 * 
	 * @param clazz
	 * @param viewIndex һ��ģ�Ϳ��ܶ�Ӧ�Ŷ��ֲ���,��һ�����ViewBridgeע���ȡ�ڼ���ֵ
	 */
	public ContentGetter(Class<T> clazz,int viewIndex){
		this.clazz = clazz;
		this.viewIndex = viewIndex;
		fields = clazz.getDeclaredFields();
	}
	
	/**
	 * �ӡ�һƬ���򡱻�ȡ������
	 * @param parentView
	 * @return
	 */
	public T getFromArea(View parentView){
		
		T t = createObject();
		
		for (Field field : fields) {
			
			ViewBridge viewBridge = field.getAnnotation(ViewBridge.class);
			if(viewBridge != null){
				int viewId = viewBridge.value()[viewIndex];
				View view = parentView.findViewById(viewId);
				if(view != null){
					setValueToField(t, field, viewId, view);
				}
			}
		}
		return t;
	}
	
	/**
	 * ��view���������һ������
	 * @param viewArray
	 * @return
	 */
	public T getFromViewArray(View... viewArray){
		int paramLength = viewArray.length;
		T t = createObject();
		for (int i = 0; i < paramLength; i++) {
			setValueToObject(t, null, viewArray[i]);
		}
		return t;
	}
	public T getFromIdArray(View parentView,int... resId){
		int paramLength = resId.length;
		T t = createObject();
		for (int i = 0; i < paramLength; i++) {
			View view = parentView.findViewById(resId[i]);
			setValueToObject(t, parentView, view);
		}
		return t;
		
	}
	
	private T createObject(){
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	private void setValueToObject(T t,View parentView,View childView){
		int viewId = childView.getId();
		
		//���viewidΪ0,�����
		if(viewId == 0){
			return ;
		}
		
		Field field = findFieldById(viewId);
		setValueToField(t, field, viewId, childView);
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void setValueToField(T t,Field field,int viewId,View childView){
		IContentRuler ruler = findRulerById(viewId);
		Object value = getValueFromView(childView);
		if(ruler != null){
			value = ruler.transToObject(value);
		}

		try {
			field.set(t, value);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	
	private Field findFieldById(int viewId){
		for (Field field : fields) {
			ViewBridge viewBridge = field.getAnnotation(ViewBridge.class);
			if(viewBridge.value()[viewIndex] == viewId){
				return field;
			}
		}
		return null;
	}

	
	
	/**
	 * ͨ��һ���Ĺ����view��ȡ��ֵ
	 * ͨ������£����õĿؼ���ȡֵ���ǹ̶��ģ��Զ���Ŀؼ���Ҫ��ӻ�ȡֵ�ķ���
	 * 1.ʵ��ICustomHandleValue
	 * 2.�ڴ���ӷ���
	 * @param view
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private Object getValueFromView(View view){
		// �ȼ���ǲ����Զ����
		if(view instanceof ICustomHandleValue){
			return ((ICustomHandleValue)view).getCustomValue();
		}
		
		//TODO �����ֶ���ӷ���
		
		// ϵͳ�Դ���view��ȡֵ
		if(view instanceof EditText){
			return ((EditText)view).getText().toString();
		}
		return null;
	}
}
