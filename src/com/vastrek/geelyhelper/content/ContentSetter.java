package com.vastrek.geelyhelper.content;

import java.lang.reflect.Field;

import com.vastrek.geelyhelper.content.ruler.IContentRuler;

import android.view.View;
import android.widget.TextView;

/**
 * @author zhaoheng
 * 从模型数据赋值到视图
 * 简单的数据赋值方式(比如EditText.setText)比较容易实现，
 * 但是涉及到自定义的显示(比如某个值控制view是否显示)则需额外实现
 */
public class ContentSetter extends ContentHandler{

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setContent(View parentView, Object object, int viewIndex) {
		Class<?> clazz = object.getClass();
		Field[] fields = clazz.getDeclaredFields();

		for (Field field : fields) {
			if (field.isAnnotationPresent(ViewBridge.class)) {
				ViewBridge viewBridge = field.getAnnotation(ViewBridge.class);
				int viewId = viewBridge.value()[viewIndex];
				View view = parentView.findViewById(viewId);

				Object value = null;
				try {
					value = field.get(object);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
				IContentRuler ruler = findRulerById(viewId);
				if (ruler != null) {
					value = ruler.transToShow(value);
				}
				setValueToView(view, value);
			}
		}
	}


	/**
	 * 通过一定的规则赋值给view 通常情况下，常用的控件赋值都是固定的，自定义的控件需要添加赋值的方法 
	 * 1.实现ICustomHandleValue
	 * 2.在此添加方法
	 * 
	 * @param view
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void setValueToView(View view, Object value) {
		// 先检测是不是自定义的
		if (view instanceof ICustomHandleValue) {
			((ICustomHandleValue) view).setCustomValue(value);
		}

		// TODO 这里手动添加方法

		
		// 系统自带的view获取值
		if(view instanceof TextView){
			((TextView) view).setText((String) value);
		}

	}
}
