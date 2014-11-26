package com.vastrek.geelyhelper.content.ruler;

/**
 * @author zhaoheng
 * ���ݹ��򹤳����������ɳ��ù���
 */
public final class ContentRulerFactory {
	
	/**
	 * ���ɲ��Թ���
	 * @return
	 */
	public static IContentRuler<String,String> getTestRuler(){
		return new IContentRuler<String,String>() {
			
			@Override
			public String transToObject(String value) {
				return "testrule";
			}

			@Override
			public String transToShow(String value) {
				return null;
			}
		};
	}
}
