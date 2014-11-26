package com.vastrek.geelyhelper.content;

import java.lang.reflect.Field;

import com.vastrek.geelyhelper.content.ruler.IContentRuler;

import android.view.View;
import android.widget.TextView;

/**
 * @author zhaoheng
 * ��ģ�����ݸ�ֵ����ͼ
 * �򵥵����ݸ�ֵ��ʽ(����EditText.setText)�Ƚ�����ʵ�֣�
 * �����漰���Զ������ʾ(����ĳ��ֵ����view�Ƿ���ʾ)�������ʵ��
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
	 * ͨ��һ���Ĺ���ֵ��view ͨ������£����õĿؼ���ֵ���ǹ̶��ģ��Զ���Ŀؼ���Ҫ��Ӹ�ֵ�ķ��� 
	 * 1.ʵ��ICustomHandleValue
	 * 2.�ڴ���ӷ���
	 * 
	 * @param view
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void setValueToView(View view, Object value) {
		// �ȼ���ǲ����Զ����
		if (view instanceof ICustomHandleValue) {
			((ICustomHandleValue) view).setCustomValue(value);
		}

		// TODO �����ֶ���ӷ���

		
		// ϵͳ�Դ���view��ȡֵ
		if(view instanceof TextView){
			((TextView) view).setText((String) value);
		}

	}
}
