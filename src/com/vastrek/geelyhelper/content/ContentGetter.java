package com.vastrek.geelyhelper.content;

import java.lang.reflect.Field;

import com.vastrek.geelyhelper.content.ruler.IContentRuler;

import android.view.View;
import android.widget.EditText;


/**
 * 
 * @author zhaoheng
 * 用来从布局或者多个View直接生成一个对象并且返回
 * @param <T> 内容返回的泛型
 */
public class ContentGetter<T> extends ContentHandler{ 

	private Class<T> clazz;
	private Field[] fields;
	private int viewIndex;

	/**
	 * 构造方法
	 * 
	 * @param clazz
	 * @param viewIndex 一个模型可能对应着多种布局,从一个域的ViewBridge注解获取第几个值
	 */
	public ContentGetter(Class<T> clazz,int viewIndex){
		this.clazz = clazz;
		this.viewIndex = viewIndex;
		fields = clazz.getDeclaredFields();
	}
	
	/**
	 * 从“一片区域”获取到对象
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
	 * 从view数组来组成一个对象
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
		
		//如果viewid为0,不予绑定
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
	 * 通过一定的规则从view获取到值
	 * 通常情况下，常用的控件获取值都是固定的，自定义的控件需要添加获取值的方法
	 * 1.实现ICustomHandleValue
	 * 2.在此添加方法
	 * @param view
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private Object getValueFromView(View view){
		// 先检测是不是自定义的
		if(view instanceof ICustomHandleValue){
			return ((ICustomHandleValue)view).getCustomValue();
		}
		
		//TODO 这里手动添加方法
		
		// 系统自带的view获取值
		if(view instanceof EditText){
			return ((EditText)view).getText().toString();
		}
		return null;
	}
}
